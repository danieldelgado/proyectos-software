package com.vst.lie.plugins;

public class ThreadProceso {
	private Thread hilo;

	ThreadProceso(Thread t) {
		hilo = t;
	}

	synchronized Thread get() {
		return hilo;
	}

	synchronized void clear() {
		hilo = null;
	}
}