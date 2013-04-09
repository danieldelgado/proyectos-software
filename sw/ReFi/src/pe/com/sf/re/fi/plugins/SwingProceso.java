package pe.com.sf.re.fi.plugins;

import javax.swing.SwingUtilities;

public abstract class SwingProceso {
	private Object value;

	private ThreadProceso threadVar;

	public SwingProceso() {
		final Runnable doFinished = new Runnable() {
			public void run() {
				finished();
			}
		};

		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					setValue(construct());
				} finally {
					threadVar.clear();
				}

				SwingUtilities.invokeLater(doFinished);
			}
		});

		threadVar = new ThreadProceso(t);
	}

	public ThreadProceso getThreadVar() {
		return threadVar;
	}

	public void setThreadVar(ThreadProceso threadVar) {
		this.threadVar = threadVar;
	}

	protected synchronized Object getValue() {
		return value;
	}

	private synchronized void setValue(Object x) {
		value = x;
	}

	public abstract Object construct();

	public void finished() {
	}

	public void interrupt() {
		Thread t = threadVar.get();
		if (t != null) {
			t.interrupt();
		}
		threadVar.clear();
	}

	public Object get() {
		while (true) {
			Thread t = threadVar.get();
			if (t == null) {
				return getValue();
			}
			try {
				t.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return null;
			}
		}
	}

	public void start() {
		Thread t = threadVar.get();
		if (t != null) {
			t.start();
		}
	}
}
