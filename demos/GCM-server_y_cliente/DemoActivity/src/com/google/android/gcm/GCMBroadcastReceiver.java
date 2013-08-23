/*    */ package com.google.android.gcm;
/*    */ 
/*    */ import android.content.BroadcastReceiver;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.util.Log;
/*    */ 
/*    */ public class GCMBroadcastReceiver extends BroadcastReceiver
/*    */ {
/*    */   private static final String TAG = "GCMBroadcastReceiver";
/*    */ 
/*    */   public final void onReceive(Context context, Intent intent)
/*    */   {
/* 42 */     Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
/* 43 */     String className = getGCMIntentServiceClassName(context);
/* 44 */     Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + className);
/*    */ 
/* 46 */     GCMBaseIntentService.runIntentInService(context, intent, className);
/* 47 */     setResult(-1, null, null);
/*    */   }
/*    */ 
/*    */   protected String getGCMIntentServiceClassName(Context context)
/*    */   {
/* 54 */     String className = context.getPackageName() + ".GCMIntentService";
/*    */ 
/* 56 */     return className;
/*    */   }
/*    */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm.jar
 * Qualified Name:     com.google.android.gcm.GCMBroadcastReceiver
 * JD-Core Version:    0.6.2
 */