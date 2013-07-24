package com.autentia.tutorial.websockets.messages;

public class MessageInfo {

	private final String from;

	private final String to;

	private final String message;

	public MessageInfo(String from, String to, String message) {
		System.out.println("new MessageInfo from:" + from + " to:" + to + " message:" + message);
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getMessage() {
		return message;
	}

}
