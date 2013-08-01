package com.test.ventaapp.domain;

public class Venta {

	private int ventaId;
    private int customerId;
    private double price;
    private String ventaCode;
  
    public Venta(int orderId, int customerId, double price, String ventaCode){
        this.ventaId = orderId;
        this.customerId = customerId;
        this.price = price;
        this.ventaCode = ventaCode;
    }

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getVentaCode() {
		return ventaCode;
	}

	public void setVentaCode(String ventaCode) {
		this.ventaCode = ventaCode;
	}
  
  
    
}
