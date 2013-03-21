package com.vst.lie.plugins;

public class LongTask {
	private int lengthOfTask;
	private int current = 0;
	private boolean done = false;
	private boolean canceled = false;
	private String statMessage;

	public LongTask() {
		lengthOfTask = 140;
	}

	public void go() {
		final SwingWorker worker = new SwingWorker() {
			public Object construct() {
				current = 0;
				done = false;
				canceled = false;
				statMessage = null;
				return new ActualTask();
			}
		};
		worker.start();
	}

	public int getLengthOfTask() {
		return lengthOfTask;
	}

	public int getCurrent() {
		return current;
	}

	public void stop() {
		canceled = true;
		statMessage = null;
	}

	public boolean isDone() {
		return done;
	}

	public String getMessage() {
		return statMessage;
	}

	class ActualTask {
		ActualTask() {
			while (!canceled && !done) {
				try {
					System.out.println(" ActualTask ");
					Thread.sleep(1000);
					System.out.println(" ActualTask despues de 1000 mls :"+current + " lengthOfTask:"+lengthOfTask);
					current += 10;
					System.out.println(" ActualTask despues de 1000 mls :"+current+ " lengthOfTask:"+lengthOfTask);
					if (current >= lengthOfTask) {
						done = true;
						current = lengthOfTask;
					}
					statMessage = "Completed " + current + " out of " + lengthOfTask + ".";
				} catch (InterruptedException e) {
					System.out.println("ActualTask interrupted");
				}
			}
		}
	}

}
