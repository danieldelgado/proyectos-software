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

import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.atmosphere.annotation.Broadcast;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.jersey.Broadcastable;
import org.atmosphere.jersey.SuspendResponse;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/subscribe/{topic}")
@Produces("text/html;charset=ISO-8859-1")
public class Subscriber {

	private static final Logger LOG = Logger.getLogger(Subscriber.class);
	public static LinkedHashMap<String, EventsLogger> lst = new LinkedHashMap<String, EventsLogger>();
	
	@PathParam("topic")
	private Broadcaster topic;

	public static int count = 0;
	
	@GET
	public SuspendResponse<String> subscribe() {
		System.out.println("Subscriber subscribe");
		LOG.debug("OnSubscribe to topic");
		EventsLogger ee = new EventsLogger();
		lst.put("strin"+(count++),ee);
		SuspendResponse<String> sr = new SuspendResponse.SuspendResponseBuilder<String>().broadcaster(topic).outputComments(true).addListener(ee).build();
		System.out.println(lst);
		return sr;
	}

	@POST
	@Broadcast
	public Broadcastable publish(@FormParam("message") String message) {
		System.out.println("Subscriber publish message:"+message);
		LOG.debug("Receive message <" + message + ">, dispatch to other connected");
		return new Broadcastable(message, "", topic);
	}
}
