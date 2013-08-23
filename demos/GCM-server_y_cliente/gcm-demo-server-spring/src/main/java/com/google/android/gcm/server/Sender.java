/*     */ package com.google.android.gcm.server;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.json.simple.JSONObject;
/*     */ import org.json.simple.JSONValue;
/*     */ import org.json.simple.parser.JSONParser;
/*     */ import org.json.simple.parser.ParseException;
/*     */ 
/*     */ public class Sender
/*     */ {
/*     */   protected static final String UTF8 = "UTF-8";
/*     */   protected static final int BACKOFF_INITIAL_DELAY = 1000;
/*     */   protected static final int MAX_BACKOFF_DELAY = 1024000;
/*  77 */   protected final Random random = new Random();
/*  78 */   protected final Logger logger = Logger.getLogger(getClass().getName());
/*     */   private final String key;
/*     */ 
/*     */   public Sender(String key)
/*     */   {
/*  88 */     this.key = ((String)nonNull(key));
/*     */   }
/*     */ 
/*     */   public Result send(Message message, String registrationId, int retries)
/*     */     throws IOException
/*     */   {
/* 111 */     int attempt = 0;
/* 112 */     Result result = null;
/* 113 */     int backoff = 1000;
/*     */     boolean tryAgain;
/*     */     do
/*     */     {
/* 116 */       attempt++;
/* 117 */       if (this.logger.isLoggable(Level.FINE)) {
/* 118 */         this.logger.fine("Attempt #" + attempt + " to send message " + message + " to regIds " + registrationId);
/*     */       }
/*     */ 
/* 121 */       result = sendNoRetry(message, registrationId);
/* 122 */       tryAgain = (result == null) && (attempt <= retries);
/* 123 */       if (tryAgain) {
/* 124 */         int sleepTime = backoff / 2 + this.random.nextInt(backoff);
/* 125 */         sleep(sleepTime);
/* 126 */         if (2 * backoff < 1024000)
/* 127 */           backoff *= 2;
/*     */       }
/*     */     }
/* 130 */     while (tryAgain);
/* 131 */     if (result == null) {
/* 132 */       throw new IOException("Could not send message after " + attempt + " attempts");
/*     */     }
/*     */ 
/* 135 */     return result;
/*     */   }
/*     */ 
/*     */   public Result sendNoRetry(Message message, String registrationId)
/*     */     throws IOException
/*     */   {
/* 150 */     StringBuilder body = newBody("registration_id", registrationId);
/* 151 */     Boolean delayWhileIdle = message.isDelayWhileIdle();
/* 152 */     if (delayWhileIdle != null) {
/* 153 */       addParameter(body, "delay_while_idle", delayWhileIdle.booleanValue() ? "1" : "0");
/*     */     }
/* 155 */     String collapseKey = message.getCollapseKey();
/* 156 */     if (collapseKey != null) {
/* 157 */       addParameter(body, "collapse_key", collapseKey);
/*     */     }
/* 159 */     Integer timeToLive = message.getTimeToLive();
/* 160 */     if (timeToLive != null) {
/* 161 */       addParameter(body, "time_to_live", Integer.toString(timeToLive.intValue()));
/*     */     }
/* 163 */     for (Map.Entry entry : message.getData().entrySet()) {
/* 164 */       String key = "data." + (String)entry.getKey();
/* 165 */       String value = (String)entry.getValue();
/* 166 */       addParameter(body, key, URLEncoder.encode(value, "UTF-8"));
/*     */     }
/* 168 */     String requestBody = body.toString();
/* 169 */     this.logger.finest("Request body: " + requestBody);
/* 170 */     HttpURLConnection conn = post("https://android.googleapis.com/gcm/send", requestBody);
/* 171 */     int status = conn.getResponseCode();
/* 172 */     if (status == 503) {
/* 173 */       this.logger.fine("GCM service is unavailable");
/* 174 */       return null;
/*     */     }
/* 176 */     if (status != 200)
/* 177 */       throw new InvalidRequestException(status);
/*     */     try
/*     */     {
/* 180 */       BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
/*     */       try
/*     */       {
/* 183 */         String line = reader.readLine();
/*     */ 
/* 185 */         if ((line == null) || (line.equals(""))) {
/* 186 */           throw new IOException("Received empty response from GCM service.");
/*     */         }
/* 188 */         String[] responseParts = split(line);
/* 189 */         String token = responseParts[0];
/* 190 */         String value = responseParts[1];
/*     */         Result.Builder builder;
/* 191 */         if (token.equals("id")) {
/* 192 */           builder = new Result.Builder().messageId(value);
/*     */ 
/* 194 */           line = reader.readLine();
/* 195 */           if (line != null) {
/* 196 */             responseParts = split(line);
/* 197 */             token = responseParts[0];
/* 198 */             value = responseParts[1];
/* 199 */             if (token.equals("registration_id"))
/* 200 */               builder.canonicalRegistrationId(value);
/*     */             else {
/* 202 */               this.logger.warning("Received invalid second line from GCM: " + line);
/*     */             }
/*     */           }
/*     */ 
/* 206 */           Result result = builder.build();
/* 207 */           if (this.logger.isLoggable(Level.FINE)) {
/* 208 */             this.logger.fine("Message created succesfully (" + result + ")");
/*     */           }
/* 210 */           return result;
/* 211 */         }if (token.equals("Error")) {
/* 212 */           return new Result.Builder().errorCode(value).build();
/*     */         }
/* 214 */         throw new IOException("Received invalid response from GCM: " + line);
/*     */       }
/*     */       finally {
/*     */       }
/*     */     }
/*     */     finally {
/* 220 */       conn.disconnect();
/*     */     }
/*     */   }
/*     */ 
/*     */   public MulticastResult send(Message message, List<String> regIds, int retries)
/*     */     throws IOException
/*     */   {
/* 246 */     int attempt = 0;
/* 247 */     MulticastResult multicastResult = null;
/* 248 */     int backoff = 1000;
/*     */ 
/* 251 */     Map<String, Result> results = new HashMap();
/* 252 */     List unsentRegIds = new ArrayList(regIds);
/*     */ 
/* 254 */     List multicastIds = new ArrayList();
/*     */     boolean tryAgain;
/*     */     do
/*     */     {
/* 256 */       attempt++;
/* 257 */       if (this.logger.isLoggable(Level.FINE)) {
/* 258 */         this.logger.fine("Attempt #" + attempt + " to send message " + message + " to regIds " + unsentRegIds);
/*     */       }
/*     */ 
/* 261 */       multicastResult = sendNoRetry(message, unsentRegIds);
/* 262 */       long multicastId = multicastResult.getMulticastId();
/* 263 */       this.logger.fine("multicast_id on attempt # " + attempt + ": " + multicastId);
/*     */ 
/* 265 */       multicastIds.add(Long.valueOf(multicastId));
/* 266 */       unsentRegIds = updateStatus(unsentRegIds, results, multicastResult);
/* 267 */       tryAgain = (!unsentRegIds.isEmpty()) && (attempt <= retries);
/* 268 */       if (tryAgain) {
/* 269 */         int sleepTime = backoff / 2 + this.random.nextInt(backoff);
/* 270 */         sleep(sleepTime);
/* 271 */         if (2 * backoff < 1024000)
/* 272 */           backoff *= 2;
/*     */       }
/*     */     }
/* 275 */     while (tryAgain);
/*     */ 
/* 277 */     int success = 0; int failure = 0; int canonicalIds = 0;
/* 278 */     for (Result result : results.values()) {
/* 279 */       if (result.getMessageId() != null) {
/* 280 */         success++;
/* 281 */         if (result.getCanonicalRegistrationId() != null)
/* 282 */           canonicalIds++;
/*     */       }
/*     */       else {
/* 285 */         failure++;
/*     */       }
/*     */     }
/*     */ 
/* 289 */     long multicastId = ((Long)multicastIds.remove(0)).longValue();
/* 290 */     MulticastResult.Builder builder = new MulticastResult.Builder(success, failure, canonicalIds, multicastId).retryMulticastIds(multicastIds);
/*     */ 
/* 293 */     for (String regId : regIds) {
/* 294 */       Result result = (Result)results.get(regId);
/* 295 */       builder.addResult(result);
/*     */     }
/* 297 */     return builder.build();
/*     */   }
/*     */ 
/*     */   private List<String> updateStatus(List<String> unsentRegIds, Map<String, Result> allResults, MulticastResult multicastResult)
/*     */   {
/* 312 */     List results = multicastResult.getResults();
/* 313 */     if (results.size() != unsentRegIds.size())
/*     */     {
/* 315 */       throw new RuntimeException("Internal error: sizes do not match. currentResults: " + results + "; unsentRegIds: " + unsentRegIds);
/*     */     }
/*     */ 
/* 318 */     List newUnsentRegIds = new ArrayList();
/* 319 */     for (int i = 0; i < unsentRegIds.size(); i++) {
/* 320 */       String regId = (String)unsentRegIds.get(i);
/* 321 */       Result result = (Result)results.get(i);
/* 322 */       allResults.put(regId, result);
/* 323 */       String error = result.getErrorCodeName();
/* 324 */       if ((error != null) && (error.equals("Unavailable"))) {
/* 325 */         newUnsentRegIds.add(regId);
/*     */       }
/*     */     }
/* 328 */     return newUnsentRegIds;
/*     */   }
/*     */ 
/*     */   public MulticastResult sendNoRetry(Message message, List<String> registrationIds)
/*     */     throws IOException
/*     */   {
/* 345 */     if (((List)nonNull(registrationIds)).isEmpty()) {
/* 346 */       throw new IllegalArgumentException("registrationIds cannot be empty");
/*     */     }
/* 348 */     Map jsonRequest = new HashMap();
/* 349 */     setJsonField(jsonRequest, "time_to_live", message.getTimeToLive());
/* 350 */     setJsonField(jsonRequest, "collapse_key", message.getCollapseKey());
/* 351 */     setJsonField(jsonRequest, "delay_while_idle", message.isDelayWhileIdle());
/*     */ 
/* 353 */     jsonRequest.put("registration_ids", registrationIds);
/* 354 */     Map payload = message.getData();
/* 355 */     if (!payload.isEmpty()) {
/* 356 */       jsonRequest.put("data", payload);
/*     */     }
/* 358 */     String requestBody = JSONValue.toJSONString(jsonRequest);
/* 359 */     this.logger.finest("JSON request: " + requestBody);
/* 360 */     HttpURLConnection conn = post("https://android.googleapis.com/gcm/send", "application/json", requestBody);
/*     */ 
/* 362 */     int status = conn.getResponseCode();
/* 363 */     String responseBody = getString(conn.getInputStream());
/* 364 */     this.logger.finest("JSON response: " + responseBody);
/* 365 */     if (status != 200) {
/* 366 */       throw new InvalidRequestException(status, responseBody);
/*     */     }
/* 368 */     JSONParser parser = new JSONParser();
/*     */     try
/*     */     {
/* 371 */       JSONObject jsonResponse = (JSONObject)parser.parse(responseBody);
/* 372 */       int success = getNumber(jsonResponse, "success").intValue();
/* 373 */       int failure = getNumber(jsonResponse, "failure").intValue();
/* 374 */       int canonicalIds = getNumber(jsonResponse, "canonical_ids").intValue();
/* 375 */       long multicastId = getNumber(jsonResponse, "multicast_id").longValue();
/* 376 */       MulticastResult.Builder builder = new MulticastResult.Builder(success, failure, canonicalIds, multicastId);
/*     */ 
/* 379 */       List<Map<String, Result>> results = (List)jsonResponse.get("results");
/*     */ 
/* 381 */       if (results != null) {
/* 382 */         for (Map jsonResult : results) {
/* 383 */           String messageId = (String)jsonResult.get("message_id");
/* 384 */           String canonicalRegId = (String)jsonResult.get("registration_id");
/*     */ 
/* 386 */           String error = (String)jsonResult.get("error");
/* 387 */           Result result = new Result.Builder().messageId(messageId).canonicalRegistrationId(canonicalRegId).errorCode(error).build();
/*     */ 
/* 392 */           builder.addResult(result);
/*     */         }
/*     */       }
/* 395 */       return builder.build();
/*     */     }
/*     */     catch (ParseException e) {
/* 398 */       throw newIoException(responseBody, e);
/*     */     } catch (CustomParserException e) {
/* 400 */       throw newIoException(responseBody, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private IOException newIoException(String responseBody, Exception e)
/*     */   {
/* 407 */     String msg = "Error parsing JSON response (" + responseBody + ")";
/* 408 */     this.logger.log(Level.WARNING, msg, e);
/* 409 */     return new IOException(msg + ":" + e);
/*     */   }
/*     */ 
/*     */   private void setJsonField(Map<Object, Object> json, String field, Object value)
/*     */   {
/* 417 */     if (value != null)
/* 418 */       json.put(field, value);
/*     */   }
/*     */ 
/*     */   private Number getNumber(Map<?, ?> json, String field)
/*     */   {
/* 423 */     Object value = json.get(field);
/* 424 */     if (value == null) {
/* 425 */       throw new CustomParserException("Missing field: " + field);
/*     */     }
/* 427 */     if (!(value instanceof Number)) {
/* 428 */       throw new CustomParserException("Field " + field + " does not contain a number: " + value);
/*     */     }
/*     */ 
/* 431 */     return (Number)value;
/*     */   }
/*     */ 
/*     */   private String[] split(String line)
/*     */     throws IOException
/*     */   {
/* 441 */     String[] split = line.split("=", 2);
/* 442 */     if (split.length != 2) {
/* 443 */       throw new IOException("Received invalid response line from GCM: " + line);
/*     */     }
/* 445 */     return split;
/*     */   }
/*     */ 
/*     */   protected HttpURLConnection post(String url, String body)
/*     */     throws IOException
/*     */   {
/* 455 */     return post(url, "application/x-www-form-urlencoded;charset=UTF-8", body);
/*     */   }
/*     */ 
/*     */   protected HttpURLConnection post(String url, String contentType, String body) throws IOException
/*     */   {
/* 460 */     if ((url == null) || (body == null)) {
/* 461 */       throw new IllegalArgumentException("arguments cannot be null");
/*     */     }
/* 463 */     if (!url.startsWith("https://")) {
/* 464 */       this.logger.warning("URL does not use https: " + url);
/*     */     }
/* 466 */     this.logger.fine("Sending POST to " + url);
/* 467 */     this.logger.finest("POST body: " + body);
/* 468 */     byte[] bytes = body.getBytes();
/* 469 */     HttpURLConnection conn = getConnection(url);
/* 470 */     conn.setDoOutput(true);
/* 471 */     conn.setUseCaches(false);
/* 472 */     conn.setFixedLengthStreamingMode(bytes.length);
/* 473 */     conn.setRequestMethod("POST");
/* 474 */     conn.setRequestProperty("Content-Type", contentType);
/* 475 */     conn.setRequestProperty("Authorization", "key=" + this.key);
/* 476 */     OutputStream out = conn.getOutputStream();
/* 477 */     out.write(bytes);
/* 478 */     out.close();
/* 479 */     return conn;
/*     */   }
/*     */ 
/*     */   protected static final Map<String, String> newKeyValues(String key, String value)
/*     */   {
/* 487 */     Map keyValues = new HashMap(1);
/* 488 */     keyValues.put(nonNull(key), nonNull(value));
/* 489 */     return keyValues;
/*     */   }
/*     */ 
/*     */   protected static StringBuilder newBody(String name, String value)
/*     */   {
/* 500 */     return new StringBuilder((String)nonNull(name)).append('=').append((String)nonNull(value));
/*     */   }
/*     */ 
/*     */   protected static void addParameter(StringBuilder body, String name, String value)
/*     */   {
/* 512 */     ((StringBuilder)nonNull(body)).append('&').append((String)nonNull(name)).append('=').append((String)nonNull(value));
/*     */   }
/*     */ 
/*     */   protected HttpURLConnection getConnection(String url)
/*     */     throws IOException
/*     */   {
/* 520 */     HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
/* 521 */     return conn;
/*     */   }
/*     */ 
/*     */   protected static String getString(InputStream stream)
/*     */     throws IOException
/*     */   {
/* 531 */     BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream)nonNull(stream)));
/*     */ 
/* 533 */     StringBuilder content = new StringBuilder();
/*     */     String newLine;
/*     */     do
/*     */     {
/* 536 */       newLine = reader.readLine();
/* 537 */       if (newLine != null)
/* 538 */         content.append(newLine).append('\n');
/*     */     }
/* 540 */     while (newLine != null);
/* 541 */     if (content.length() > 0)
/*     */     {
/* 543 */       content.setLength(content.length() - 1);
/*     */     }
/* 545 */     return content.toString();
/*     */   }
/*     */ 
/*     */   static <T> T nonNull(T argument) {
/* 549 */     if (argument == null) {
/* 550 */       throw new IllegalArgumentException("argument cannot be null");
/*     */     }
/* 552 */     return argument;
/*     */   }
/*     */ 
/*     */   void sleep(long millis) {
/*     */     try {
/* 557 */       Thread.sleep(millis);
/*     */     } catch (InterruptedException e) {
/* 559 */       Thread.currentThread().interrupt();
/*     */     }
/*     */   }
/*     */ 
/*     */   class CustomParserException extends RuntimeException
/*     */   {
/*     */     CustomParserException(String message)
/*     */     {
/* 436 */       super();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\ddelgado\Desktop\temp\jd-gui\gcm-server-1.jar
 * Qualified Name:     com.google.android.gcm.server.Sender
 * JD-Core Version:    0.6.2
 */