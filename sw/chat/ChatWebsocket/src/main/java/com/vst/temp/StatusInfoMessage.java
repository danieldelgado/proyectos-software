package com.vst.temp;



public class StatusInfoMessage {

	private StatusInfo statusInfo;

	public StatusInfoMessage(Usuario user, STATUS status, int sta) {
		this.statusInfo = new StatusInfo(user, status, sta);
	}

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

}
