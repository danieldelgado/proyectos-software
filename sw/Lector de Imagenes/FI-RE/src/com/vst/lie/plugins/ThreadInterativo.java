package com.vst.lie.plugins;

import com.vst.lie.util.Constantes;

public class ThreadInterativo {
	
	public int maximo;
	public int procesoActual = 0;
	public boolean hecho = false;
	public boolean cancelado = false;
	public String mensaje;
	public boolean  start = false;
	
	public void go() {
		final SwingProceso worker = new SwingProceso() {
			public Object construct() {
				procesoActual = 0;
				hecho = false;
				cancelado = false;
				start = false;
				mensaje = null;
				return new ActualProceso();
			}
		};
		worker.start();
	}

	public boolean isCanceled() {
		return cancelado;
	}

	public void setCanceled(boolean canceled) {
		this.cancelado = canceled;
	}

	public String getStatMessage() {
		return mensaje;
	}

	public void setStatMessage(String statMessage) {
		this.mensaje = statMessage;
	}

	public void setLengthOfTask(int lengthOfTask) {
		this.maximo = lengthOfTask;
	}

	public void setCurrent(int current) {
		this.procesoActual = current;
	}

	public void setDone(boolean done) {
		this.hecho = done;
	}

	public int getLengthOfTask() {
		return maximo;
	}

	public int getCurrent() {
		return procesoActual;
	}

	public void stop() {
		cancelado = true;
		start=false;
		mensaje = null;
	}

	public boolean isDone() {
		return hecho;
	}

	public String getMessage() {
		return mensaje;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	class ActualProceso {
		ActualProceso() {
			while (!cancelado && !hecho) {
				start = true;
				try {
					Thread.sleep(Constantes.TIEMPO_INTERACION);
					procesoActual += 1;
					if (procesoActual >= maximo) {
						hecho = true;
						procesoActual = maximo;
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
