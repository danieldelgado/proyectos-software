package com.test.ventaapp.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ventaapp.domain.Venta;

@Service("ventaService")
public class VentaService {
    static int ventaSequence = 1;
   
    @Autowired
    private VentaSender ventaSender;
    public void setVentaSender(VentaSender ventaSender){
        this.ventaSender = ventaSender;
    }
   
    public void sendVenta(int customerId, double price)
    {
        Venta venta = new Venta(ventaSequence, 2, price, "ventacd"+ ventaSequence++);
        ventaSender.sendVenta(venta);
    }
}