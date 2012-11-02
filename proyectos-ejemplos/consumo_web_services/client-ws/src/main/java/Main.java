import java.rmi.RemoteException;

import com.vst.ws.HelloWorldServiceProxy;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldServiceProxy proxy = new HelloWorldServiceProxy();
		try {
			System.out.println("proxy : "+ proxy.sayHello(" holaaaaa"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
