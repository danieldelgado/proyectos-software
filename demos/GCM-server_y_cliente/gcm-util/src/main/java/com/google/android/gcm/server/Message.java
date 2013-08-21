/*     */ package com.google.android.gcm.server;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public final class Message
/*     */   implements Serializable
/*     */ {
/*     */   private final String collapseKey;
/*     */   private final Boolean delayWhileIdle;
/*     */   private final Integer timeToLive;
/*     */   private final Map<String, String> data;
/*     */ 
/*     */   private Message(Builder builder)
/*     */   {
/* 114 */     this.collapseKey = builder.collapseKey;
/* 115 */     this.delayWhileIdle = builder.delayWhileIdle;
/* 116 */     this.data = Collections.unmodifiableMap(builder.data);
/* 117 */     this.timeToLive = builder.timeToLive;
/*     */   }
/*     */ 
/*     */   public String getCollapseKey()
/*     */   {
/* 124 */     return this.collapseKey;
/*     */   }
/*     */ 
/*     */   public Boolean isDelayWhileIdle()
/*     */   {
/* 131 */     return this.delayWhileIdle;
/*     */   }
/*     */ 
/*     */   public Integer getTimeToLive()
/*     */   {
/* 138 */     return this.timeToLive;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getData()
/*     */   {
/* 145 */     return this.data;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 150 */     StringBuilder builder = new StringBuilder("Message(");
/* 151 */     if (this.collapseKey != null) {
/* 152 */       builder.append("collapseKey=").append(this.collapseKey).append(", ");
/*     */     }
/* 154 */     if (this.timeToLive != null) {
/* 155 */       builder.append("timeToLive=").append(this.timeToLive).append(", ");
/*     */     }
/* 157 */     if (this.delayWhileIdle != null) {
/* 158 */       builder.append("delayWhileIdle=").append(this.delayWhileIdle).append(", ");
/*     */     }
/* 160 */     if (!this.data.isEmpty()) {
/* 161 */       builder.append("data: {");
/* 162 */       for (Map.Entry entry : this.data.entrySet()) {
/* 163 */         builder.append((String)entry.getKey()).append("=").append((String)entry.getValue()).append(",");
/*     */       }
/*     */ 
/* 166 */       builder.delete(builder.length() - 1, builder.length());
/* 167 */       builder.append("}");
/*     */     }
/* 169 */     if (builder.charAt(builder.length() - 1) == ' ') {
/* 170 */       builder.delete(builder.length() - 2, builder.length());
/*     */     }
/* 172 */     builder.append(")");
/* 173 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   public static final class Builder
/*     */   {
/*     */     private final Map<String, String> data;
/*     */     private String collapseKey;
/*     */     private Boolean delayWhileIdle;
/*     */     private Integer timeToLive;
/*     */ 
/*     */     public Builder()
/*     */     {
/*  72 */       this.data = new LinkedHashMap();
/*     */     }
/*     */ 
/*     */     public Builder collapseKey(String value)
/*     */     {
/*  79 */       this.collapseKey = value;
/*  80 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder delayWhileIdle(boolean value)
/*     */     {
/*  87 */       this.delayWhileIdle = Boolean.valueOf(value);
/*  88 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder timeToLive(int value)
/*     */     {
/*  95 */       this.timeToLive = Integer.valueOf(value);
/*  96 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder addData(String key, String value)
/*     */     {
/* 103 */       this.data.put(key, value);
/* 104 */       return this;
/*     */     }
/*     */ 
/*     */     public Message build() {
/* 108 */       return new Message(this);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm-server-1.jar
 * Qualified Name:     com.google.android.gcm.server.Message
 * JD-Core Version:    0.6.2
 */