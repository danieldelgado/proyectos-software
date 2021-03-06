/*
 * Copyright 2012 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.samples.multirequest.handlers;

import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.websocket.WebSocketEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsLogger implements WebSocketEventListener {

//	private static final Logger logger = Logger.getLogger(EventsLogger.class);
	private static final Logger logger = LoggerFactory.getLogger(EventsLogger.class);

	
	
	int count = 0;
	
	
	public EventsLogger() {
		count++;
		System.out.println("EventsLogger " +count);
		System.out.println("EventsLogger");
		System.out.println("EventsLogger");
	}

	@Override
	public void onPreSuspend(AtmosphereResourceEvent event) {
		System.out.println("onPreSuspend " +count);
	}

	public void onSuspend(final AtmosphereResourceEvent event) {
		
		System.out.println("onSuspend " +count);
		logger.debug("onSuspend(): " + event.getResource().getRequest().getRemoteAddr() + ":" + event.getResource().getRequest().getRemotePort());
	}

	public void onResume(AtmosphereResourceEvent event) {
		
		System.out.println("onResume " +count);
		logger.debug("onResume(): " + event.getResource().getRequest().getRemoteAddr() + ":" + event.getResource().getRequest().getRemotePort());
	}

	public void onDisconnect(AtmosphereResourceEvent event) {
		
		System.out.println("onDisconnect  " +count);
		logger.debug("onDisconnect(): " + event.getResource().getRequest().getRemoteAddr() + ":" + event.getResource().getRequest().getRemotePort());
	}

	public void onBroadcast(AtmosphereResourceEvent event) {
		
		System.out.println("onBroadcast " +count);
		logger.debug("onBroadcast(): " + event.getMessage());
	}

	public void onThrowable(AtmosphereResourceEvent event) {
		
		System.out.println("onThrowable " +count);
		logger.warn("onThrowable(): " + event);
	}

	public void onHandshake(WebSocketEvent event) {
		
		System.out.println("onHandshake " +count);
		logger.debug("onHandshake(): " + event);
	}

	public void onMessage(WebSocketEvent event) {
		System.out.println("onMessage " +count);
		logger.debug("onMessage(): " + event);
	}

	public void onClose(WebSocketEvent event) {
		
		System.out.println("onClose " +count);		
		logger.debug("onClose(): " + event);
	}

	public void onControl(WebSocketEvent event) {
		
		System.out.println("onControl " +count);
		logger.debug("onControl(): " + event);
	}

	public void onDisconnect(WebSocketEvent event) {
		
		System.out.println("onDisconnect " +count);
		logger.debug("onDisconnect(): " + event);
	}

	public void onConnect(WebSocketEvent event) {
		
		System.out.println("onConnect " +count);
		logger.debug("onConnect(): " + event);
	}
}