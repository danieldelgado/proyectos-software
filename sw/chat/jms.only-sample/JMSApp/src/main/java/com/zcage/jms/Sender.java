package com.zcage.jms;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender {

    private String user = "admin";
    private String password = "admin";
    private String url = "failover://(tcp://192.168.1.146:61616)?randomize=false";

    private Destination destination;
    private Connection connection = null;
    private Session session = null;
    private ActiveMQConnectionFactory connectionFactory;
    private MessageProducer producer;

    
   public static void main(String[] args) {
	new Sender("prueba01").sendMessage("mesj");
   }
    
    
    public Sender(String topicId) {
        try {
            connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connectionFactory.setDispatchAsync(false);

            connection = connectionFactory.createTopicConnection(user, password);
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic(topicId);

            producer = session.createProducer(destination);
        } catch (JMSException ex) {
//            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }

    public void sendMessage(String message) {
        try {
            BytesMessage message1 = session.createBytesMessage();
//            message1.setLongProperty("text", message1);
            message1.setStringProperty("text", message);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
           
            producer.send(destination, message1);
        } catch (JMSException ex) {
//            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
//            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}