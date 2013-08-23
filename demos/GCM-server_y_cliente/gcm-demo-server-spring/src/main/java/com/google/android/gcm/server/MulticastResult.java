/*     */ package com.google.android.gcm.server;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ public final class MulticastResult
/*     */   implements Serializable
/*     */ {
/*     */   private final int success;
/*     */   private final int failure;
/*     */   private final int canonicalIds;
/*     */   private final long multicastId;
/*     */   private final List<Result> results;
/*     */   private final List<Long> retryMulticastIds;
/*     */ 
/*     */   private MulticastResult(Builder builder)
/*     */   {
/*  72 */     this.success = builder.success;
/*  73 */     this.failure = builder.failure;
/*  74 */     this.canonicalIds = builder.canonicalIds;
/*  75 */     this.multicastId = builder.multicastId;
/*  76 */     this.results = Collections.unmodifiableList(builder.results);
/*  77 */     List tmpList = builder.retryMulticastIds;
/*  78 */     if (tmpList == null) {
/*  79 */       tmpList = Collections.emptyList();
/*     */     }
/*  81 */     this.retryMulticastIds = Collections.unmodifiableList(tmpList);
/*     */   }
/*     */ 
/*     */   public long getMulticastId()
/*     */   {
/*  88 */     return this.multicastId;
/*     */   }
/*     */ 
/*     */   public int getSuccess()
/*     */   {
/*  95 */     return this.success;
/*     */   }
/*     */ 
/*     */   public int getTotal()
/*     */   {
/* 102 */     return this.success + this.failure;
/*     */   }
/*     */ 
/*     */   public int getFailure()
/*     */   {
/* 109 */     return this.failure;
/*     */   }
/*     */ 
/*     */   public int getCanonicalIds()
/*     */   {
/* 117 */     return this.canonicalIds;
/*     */   }
/*     */ 
/*     */   public List<Result> getResults()
/*     */   {
/* 124 */     return this.results;
/*     */   }
/*     */ 
/*     */   public List<Long> getRetryMulticastIds()
/*     */   {
/* 131 */     return this.retryMulticastIds;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 136 */     StringBuilder builder = new StringBuilder("MulticastResult(").append("multicast_id=").append(this.multicastId).append(",").append("total=").append(getTotal()).append(",").append("success=").append(this.success).append(",").append("failure=").append(this.failure).append(",").append("canonical_ids=").append(this.canonicalIds).append(",");
/*     */ 
/* 142 */     if (!this.results.isEmpty()) {
/* 143 */       builder.append("results: " + this.results);
/*     */     }
/* 145 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   static final class Builder
/*     */   {
/*  37 */     private final List<Result> results = new ArrayList();
/*     */     private final int success;
/*     */     private final int failure;
/*     */     private final int canonicalIds;
/*     */     private final long multicastId;
/*     */     private List<Long> retryMulticastIds;
/*     */ 
/*     */     public Builder(int success, int failure, int canonicalIds, long multicastId)
/*     */     {
/*  50 */       this.success = success;
/*  51 */       this.failure = failure;
/*  52 */       this.canonicalIds = canonicalIds;
/*  53 */       this.multicastId = multicastId;
/*     */     }
/*     */ 
/*     */     public Builder addResult(Result result) {
/*  57 */       this.results.add(result);
/*  58 */       return this;
/*     */     }
/*     */ 
/*     */     public Builder retryMulticastIds(List<Long> retryMulticastIds) {
/*  62 */       this.retryMulticastIds = retryMulticastIds;
/*  63 */       return this;
/*     */     }
/*     */ 
/*     */     public MulticastResult build() {
/*  67 */       return new MulticastResult(this);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm-server-1.jar
 * Qualified Name:     com.google.android.gcm.server.MulticastResult
 * JD-Core Version:    0.6.2
 */