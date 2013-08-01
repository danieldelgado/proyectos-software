package com.test.ventaapp.listener;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class VentaListener {

	public void ventaReceived(Map<String, Object> message) throws Exception {
		System.out.println("orderReceived:"+message);
		int ventaId = (Integer) message.get("ventaId");
		int customerId = (Integer) message.get("customerId");
		double price = (Double) message.get("price");
		String ventaCode = (String) message.get("ventaCode");
//		Venta customer = new Venta(ventaId, customerId, price, ventaCode);
		System.out.println("Venta rebibida del activeMQ: " + ventaId + ", customerId: " + customerId + ", price: " + price + " ventaCode:"+ventaCode);
	}
}