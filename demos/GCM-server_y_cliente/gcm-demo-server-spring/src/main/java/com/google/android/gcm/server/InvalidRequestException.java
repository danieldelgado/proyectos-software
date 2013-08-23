/*    */ package com.google.android.gcm.server;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public final class InvalidRequestException extends IOException
/*    */ {
/*    */   private final int status;
/*    */   private final String description;
/*    */ 
/*    */   public InvalidRequestException(int status)
/*    */   {
/* 31 */     this(status, null);
/*    */   }
/*    */ 
/*    */   public InvalidRequestException(int status, String description) {
/* 35 */     super(getMessage(status, description));
/* 36 */     this.status = status;
/* 37 */     this.description = description;
/*    */   }
/*    */ 
/*    */   private static String getMessage(int status, String description) {
/* 41 */     StringBuilder base = new StringBuilder("HTTP Status Code: ").append(status);
/* 42 */     if (description != null) {
/* 43 */       base.append("(").append(description).append(")");
/*    */     }
/* 45 */     return base.toString();
/*    */   }
/*    */ 
/*    */   public int getHttpStatusCode()
/*    */   {
/* 52 */     return this.status;
/*    */   }
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 59 */     return this.description;
/*    */   }
/*    */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm-server-1.jar
 * Qualified Name:     com.google.android.gcm.server.InvalidRequestException
 * JD-Core Version:    0.6.2
 */