/*     */ package com.google.android.util.gcm;
/*     */ 
/*     */ import android.app.AlarmManager;
/*     */ import android.app.IntentService;
/*     */ import android.app.PendingIntent;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.os.PowerManager;
/*     */ import android.os.PowerManager.WakeLock;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ public abstract class GCMBaseIntentService extends IntentService
/*     */ {
/*     */   public static final String TAG = "GCMBaseIntentService";
/*     */   private static final String WAKELOCK_KEY = "GCM_LIB";
/*     */   private static PowerManager.WakeLock sWakeLock;
/*  60 */   private static final Object LOCK = GCMBaseIntentService.class;
/*     */   private final String mSenderId;
/*  65 */   private static int sCounter = 0;
/*     */ 
/*  67 */   private static final Random sRandom = new Random();
/*     */ 
/*  69 */   private static final int MAX_BACKOFF_MS = (int)TimeUnit.SECONDS.toMillis(3600L);
/*     */ 
/*  73 */   private static final String TOKEN = Long.toBinaryString(sRandom.nextLong());
/*     */   private static final String EXTRA_TOKEN = "token";
/*     */ 
/*     */   protected GCMBaseIntentService(String senderId)
/*     */   {
/*  83 */     super("GCMIntentService-" + senderId + "-" + ++sCounter);
/*  84 */     this.mSenderId = senderId;
/*     */   }
/*     */ 
/*     */   protected abstract void onMessage(Context paramContext, Intent paramIntent);
/*     */ 
/*     */   protected void onDeletedMessages(Context context, int total)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected boolean onRecoverableError(Context context, String errorId)
/*     */   {
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   protected abstract void onError(Context paramContext, String paramString);
/*     */ 
/*     */   protected abstract void onRegistered(Context paramContext, String paramString);
/*     */ 
/*     */   protected abstract void onUnregistered(Context paramContext, String paramString);
/*     */ 
/*     */   public final void onHandleIntent(Intent intent)
/*     */   {
/*     */     try
/*     */     {
/* 150 */       Context context = getApplicationContext();
/* 151 */       String action = intent.getAction();
/* 152 */       if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
/* 153 */         handleRegistration(context, intent);
/* 154 */       } else if (action.equals("com.google.android.c2dm.intent.RECEIVE"))
/*     */       {
/* 156 */         String messageType = intent.getStringExtra("message_type");
/*     */ 
/* 158 */         if (messageType != null) {
/* 159 */           if (messageType.equals("deleted_messages")) {
/* 160 */             String sTotal = intent.getStringExtra("total_deleted");
/*     */ 
/* 162 */             if (sTotal != null) {
/*     */               try {
/* 164 */                 int total = Integer.parseInt(sTotal);
/* 165 */                 Log.v("GCMBaseIntentService", "Received deleted messages notification: " + total);
/*     */ 
/* 167 */                 onDeletedMessages(context, total);
/*     */               } catch (NumberFormatException e) {
/* 169 */                 Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + sTotal);
/*     */               }
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 175 */             Log.e("GCMBaseIntentService", "Received unknown special message: " + messageType);
/*     */           }
/*     */         }
/*     */         else
/* 179 */           onMessage(context, intent);
/*     */       }
/* 181 */       else if (action.equals("com.google.android.gcm.intent.RETRY")) {
/* 182 */         String token = intent.getStringExtra("token");
/* 183 */         if (!TOKEN.equals(token))
/*     */         {
/* 186 */           Log.e("GCMBaseIntentService", "Received invalid token: " + token);
/*     */           return;
/*     */         }
/*     */ 
/* 190 */         if (GCMRegistrar.isRegistered(context))
/* 191 */           GCMRegistrar.internalUnregister(context);
/*     */         else {
/* 193 */           GCMRegistrar.internalRegister(context, new String[] { this.mSenderId });
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 203 */       synchronized (LOCK)
/*     */       {
/* 205 */         if (sWakeLock != null) {
/* 206 */           Log.v("GCMBaseIntentService", "Releasing wakelock");
/* 207 */           sWakeLock.release();
/*     */         }
/*     */         else {
/* 210 */           Log.e("GCMBaseIntentService", "Wakelock reference is null");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   static void runIntentInService(Context context, Intent intent, String className)
/*     */   {
/* 225 */     synchronized (LOCK) {
/* 226 */       if (sWakeLock == null)
/*     */       {
/* 228 */         PowerManager pm = (PowerManager)context.getSystemService("power");
/*     */ 
/* 230 */         sWakeLock = pm.newWakeLock(1, "GCM_LIB");
/*     */       }
/*     */     }
/*     */ 
/* 234 */     Log.v("GCMBaseIntentService", "Acquiring wakelock");
/* 235 */     sWakeLock.acquire();
/* 236 */     intent.setClassName(context, className);
/* 237 */     context.startService(intent);
/*     */   }
/*     */ 
/*     */   private void handleRegistration(Context context, Intent intent) {
/* 241 */     String registrationId = intent.getStringExtra("registration_id");
/* 242 */     String error = intent.getStringExtra("error");
/* 243 */     String unregistered = intent.getStringExtra("unregistered");
/* 244 */     Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + registrationId + ", error = " + error + ", unregistered = " + unregistered);
/*     */ 
/* 248 */     if (registrationId != null) {
/* 249 */       GCMRegistrar.resetBackoff(context);
/* 250 */       GCMRegistrar.setRegistrationId(context, registrationId);
/* 251 */       onRegistered(context, registrationId);
/* 252 */       return;
/*     */     }
/*     */ 
/* 256 */     if (unregistered != null)
/*     */     {
/* 258 */       GCMRegistrar.resetBackoff(context);
/* 259 */       String oldRegistrationId = GCMRegistrar.clearRegistrationId(context);
/*     */ 
/* 261 */       onUnregistered(context, oldRegistrationId);
/* 262 */       return;
/*     */     }
/*     */ 
/* 266 */     Log.d("GCMBaseIntentService", "Registration error: " + error);
/*     */ 
/* 268 */     if ("SERVICE_NOT_AVAILABLE".equals(error)) {
/* 269 */       boolean retry = onRecoverableError(context, error);
/* 270 */       if (retry) {
/* 271 */         int backoffTimeMs = GCMRegistrar.getBackoff(context);
/* 272 */         int nextAttempt = backoffTimeMs / 2 + sRandom.nextInt(backoffTimeMs);
/*     */ 
/* 274 */         Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + nextAttempt + " (" + backoffTimeMs + ")");
/*     */ 
/* 276 */         Intent retryIntent = new Intent("com.google.android.gcm.intent.RETRY");
/*     */ 
/* 278 */         retryIntent.putExtra("token", TOKEN);
/* 279 */         PendingIntent retryPendingIntent = PendingIntent.getBroadcast(context, 0, retryIntent, 0);
/*     */ 
/* 281 */         AlarmManager am = (AlarmManager)context.getSystemService("alarm");
/*     */ 
/* 283 */         am.set(3, SystemClock.elapsedRealtime() + nextAttempt, retryPendingIntent);
/*     */ 
/* 287 */         if (backoffTimeMs < MAX_BACKOFF_MS)
/* 288 */           GCMRegistrar.setBackoff(context, backoffTimeMs * 2);
/*     */       }
/*     */       else {
/* 291 */         Log.d("GCMBaseIntentService", "Not retrying failed operation");
/*     */       }
/*     */     }
/*     */     else {
/* 295 */       onError(context, error);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm.jar
 * Qualified Name:     com.google.android.gcm.GCMBaseIntentService
 * JD-Core Version:    0.6.2
 */