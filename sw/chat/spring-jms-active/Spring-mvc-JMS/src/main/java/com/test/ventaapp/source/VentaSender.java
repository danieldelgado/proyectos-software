package com.test.ventaapp.source;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.test.ventaapp.domain.Venta;

public class VentaSender {
   
    @Autowired
    private JmsTemplate jmsTemplate;
   
    public void sendVenta(final Venta venta){
        jmsTemplate.send(
        new MessageCreator() {
          public Message createMessage(Session session) throws JMSException {
               MapMessage mapMessage = session.createMapMessage();
               mapMessage.setInt("ventaId", venta.getVentaId());
               mapMessage.setInt("customerId", venta.getCustomerId());
               mapMessage.setDouble("price", venta.getPrice());
               mapMessage.setString("ventaCode", venta.getVentaCode());
               return mapMessage;
          }
        }
        );
        System.out.println("Venta enviada - id: "+ venta.getVentaId());
    }
}