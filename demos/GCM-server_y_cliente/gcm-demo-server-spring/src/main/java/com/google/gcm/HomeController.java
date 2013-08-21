package com.google.gcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.bean.Shop;
import com.google.gcm.util.Constantes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	static final boolean DEBUG = true;
	private static final String PARAMETER_REG_ID = "regId";
	static final String ATTRIBUTE_STATUS = "status";
	private static final int MULTICAST_SIZE = 1000;
	private Sender sender;
	private static final Executor threadPool = Executors.newFixedThreadPool(5);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model) throws IOException {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<html><body>");
		out.print("<head>");
		out.print("  <title>GCM Demo</title>");
		out.print("  <link rel='icon' href='favicon.png'/>");
		out.print("</head>");
		String status = (String) req.getAttribute(ATTRIBUTE_STATUS);
		if (status != null) {
			out.print(status);
		}
		List<String> devices = Datastore.getDevices();
		if (devices.isEmpty()) {
			out.print("<h2>No devices registered!</h2>");
		} else {
			out.print("<h2>" + devices.size() + " device(s) registered!</h2>");
			out.print("<form name='form' method='POST' action='sendAll'>");
			out.print("<input type='submit' value='Send Message' />");
			out.print("</form>");
		}
		out.print("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
		// return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public void home2(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model) throws IOException {
		home(req, resp, locale, model);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model) {

		String regId;
		try {
			regId = getParameter(req, PARAMETER_REG_ID);
			Datastore.register(regId);
			setSuccess(resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/sendAll", method = RequestMethod.POST)
	public void sendAll(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model) throws ServletException, IOException {

		String ky = Constantes.PK_GOOGLE;
		sender = new Sender(ky);
		System.out.println("sender");
		System.out.println(sender);
		List<String> devices = Datastore.getDevices();
		String status;
		if (devices.isEmpty()) {
			status = "Message ignored as there is no device registered!";
		} else {
			// NOTE: check below is for demonstration purposes; a real
			// application
			// could always send a multicast, even for just one recipient
			if (devices.size() == 1) {
				// send a single message using plain post
				String registrationId = devices.get(0);
				// Message message = new Message.Builder().build();
				Message message = new Message.Builder()

				// If multiple messages are sent using the same .collapseKey()
				// the android target device, if it was offline during earlier
				// message
				// transmissions, will only receive the latest message for that
				// key when
				// it goes back on-line.
				// .collapseKey(collapseKey)
						.timeToLive(30).delayWhileIdle(true).addData("message", "mesnaje desde servidor").build();
				System.out.println(message);
				System.out.println(message.getCollapseKey());
				System.out.println(message.getData());
				Result result = sender.send(message, registrationId, 5);
				status = "Sent message to one device: " + result;
				System.out.println(status);
			} else {
				// send a multicast message using JSON
				// must split in chunks of 1000 devices (GCM limit)
				int total = devices.size();
				List<String> partialDevices = new ArrayList<String>(total);
				int counter = 0;
				int tasks = 0;
				for (String device : devices) {
					counter++;
					partialDevices.add(device);
					int partialSize = partialDevices.size();
					if (partialSize == MULTICAST_SIZE || counter == total) {
						asyncSend(partialDevices);
						partialDevices.clear();
						tasks++;
					}
				}
				status = "Asynchronously sending " + tasks + " multicast messages to " + total + " devices";
				System.out.println(status);
			}
		}
		req.setAttribute(ATTRIBUTE_STATUS, status.toString());
		// req.getServletContext().getRequestDispatcher("/home").forward(req,
		// resp);
		req.getSession().getServletContext().getRequestDispatcher("/home").forward(req, resp);
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public void unregister(HttpServletRequest req, HttpServletResponse resp, Locale locale, Model model) throws ServletException, IOException {
		String regId = getParameter(req, PARAMETER_REG_ID);
		Datastore.unregister(regId);
		setSuccess(resp);
	}
	
	@RequestMapping(value="/json/{name}", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON(@PathVariable String name) {
 
		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
 
		return shop;
 
	}
 
	
	
	//////////////////////////////////////////////// METODOS EXTRAS  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void asyncSend(List<String> partialDevices) {
		// make a copy
		final List<String> devices = new ArrayList<String>(partialDevices);
		threadPool.execute(new Runnable() {

			public void run() {
				// Message message = new Message.Builder().build();
				Message message = new Message.Builder()

				// If multiple messages are sent using the same .collapseKey()
				// the android target device, if it was offline during earlier
				// message
				// transmissions, will only receive the latest message for that
				// key when
				// it goes back on-line.
				// .collapseKey(collapseKey)
						.timeToLive(30).delayWhileIdle(true).addData("message", "mensaje desde servidor").build();

				MulticastResult multicastResult;
				try {
					multicastResult = sender.send(message, devices, 5);
				} catch (IOException e) {
					logger.info("Error posting messages", e);
					return;
				}
				List<Result> results = multicastResult.getResults();
				// analyze the results
				for (int i = 0; i < devices.size(); i++) {
					String regId = devices.get(i);
					Result result = results.get(i);
					String messageId = result.getMessageId();
					if (messageId != null) {
						logger.info("Succesfully sent message to device: " + regId + "; messageId = " + messageId);
						String canonicalRegId = result.getCanonicalRegistrationId();
						if (canonicalRegId != null) {
							// same device has more than on registration id:
							// update it
							logger.info("canonicalRegId " + canonicalRegId);
							Datastore.updateRegistration(regId, canonicalRegId);
						}
					} else {
						String error = result.getErrorCodeName();
						if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
							// application has been removed from device -
							// unregister it
							logger.info("Unregistered device: " + regId);
							Datastore.unregister(regId);
						} else {
							logger.info("Error sending message to " + regId + ": " + error);
						}
					}
				}
			}
		});
	}

	public String getParameter(HttpServletRequest req, String parameter) throws ServletException {
		String value = req.getParameter(parameter);
		if (isEmptyOrNull(value)) {
			if (DEBUG) {
				StringBuilder parameters = new StringBuilder();
				@SuppressWarnings("unchecked")
				Enumeration<String> names = req.getParameterNames();
				while (names.hasMoreElements()) {
					String name = names.nextElement();
					String param = req.getParameter(name);
					parameters.append(name).append("=").append(param).append("\n");
				}
				logger.info("parameters: " + parameters);
			}
			throw new ServletException("Parameter " + parameter + " not found");
		}
		return value.trim();
	}

	public String getParameter(HttpServletRequest req, String parameter, String defaultValue) {
		String value = req.getParameter(parameter);
		if (isEmptyOrNull(value)) {
			value = defaultValue;
		}
		return value.trim();
	}

	public void setSuccess(HttpServletResponse resp) {
		setSuccess(resp, 0);
	}

	public void setSuccess(HttpServletResponse resp, int size) {
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.setContentLength(size);
	}

	public boolean isEmptyOrNull(String value) {
		return value == null || value.trim().length() == 0;
	}
}
