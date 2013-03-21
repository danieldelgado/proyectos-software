package com.vst.lie.plugins;

public class ThreadVar {
	private Thread thread;

	ThreadVar(Thread t) {
		thread = t;
	}

	synchronized Thread get() {
		return thread;
	}

	synchronized void clear() {
		thread = null;
	}
}