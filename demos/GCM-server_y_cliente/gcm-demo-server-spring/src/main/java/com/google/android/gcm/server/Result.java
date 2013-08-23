/*     */ package com.google.android.gcm.server;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public final class Result
/*     */   implements Serializable
/*     */ {
/*     */   private final String messageId;
/*     */   private final String canonicalRegistrationId;
/*     */   private final String errorCode;
/*     */ 
/*     */   private Result(Builder builder)
/*     */   {
/*  80 */     this.canonicalRegistrationId = builder.canonicalRegistrationId;
/*  81 */     this.messageId = builder.messageId;
/*  82 */     this.errorCode = builder.errorCode;
/*     */   }
/*     */ 
/*     */   public String getMessageId()
/*     */   {
/*  89 */     return this.messageId;
/*     */   }
/*     */ 
/*     */   public String getCanonicalRegistrationId()
/*     */   {
/*  96 */     return this.canonicalRegistrationId;
/*     */   }
/*     */ 
/*     */   public String getErrorCodeName()
/*     */   {
/* 103 */     return this.errorCode;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 108 */     StringBuilder builder = new StringBuilder("[");
/* 109 */     if (this.messageId != null) {
/* 110 */       builder.append(" messageId=").append(this.messageId);
/*     */     }
/* 112 */     if (this.canonicalRegistrationId != null) {
/* 113 */       builder.append(" canonicalRegistrationId=").append(this.canonicalRegistrationId);
/*     */     }
/*     */ 
/* 116 */     if (this.errorCode != null) {
/* 117 */       builder.append(" errorCode=").append(this.errorCode);
/*     */     }
/* 119 */     return " ]";
/*     */   }
/*     */ 
/*     */   static final class Builder
/*     */   {
/*     */     private String messageId;
/*     */     private String canonicalRegistrationId;
/*     */     private String errorCode;
/*     */ 
/*     */     public Builder canonicalRegistrationId(String value)
/*     */     {
/*  60 */       this.canonicalRegistrationId = value;
/*  61 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder messageId(String value) {
/*  65 */       this.messageId = value;
/*  66 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder errorCode(String value) {
/*  70 */       this.errorCode = value;
/*  71 */       return this;
/*     */     }
/*     */ 
/*     */     public Result build() {
/*  75 */       return new Result(this);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm-server-1.jar
 * Qualified Name:     com.google.android.gcm.server.Result
 * JD-Core Version:    0.6.2
 */