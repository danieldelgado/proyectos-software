package com.zcage.jms;


import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.util.IdGenerator;


public class Receiver {
    private String url = "failover://(tcp://192.168.1.146:61616)?randomize=false";
    private ActiveMQConnectionFactory connectionFactory;
    private Connection connection;
    private Session session = null;
    private Topic destination = null;
    private TopicSubscriber consumer;
    private IdGenerator clientIdGenerator = new IdGenerator();
    
    public static void main(String[] args) {
    	new Receiver("prueba01", new MessageListener() {			
			@Override
			public void onMessage(Message message) {
				System.out.println(" message; "+message);				
			}
		});
       }
    
    public Receiver(String topicId, MessageListener listener) {
        try {
            connectionFactory = new ActiveMQConnectionFactory(url);
            connectionFactory.setDispatchAsync(false);

            connection = connectionFactory.createTopicConnection();
            connection.setClientID(clientIdGenerator.generateId());
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            destination = session.createTopic(topicId);
            consumer = session.createDurableSubscriber(destination, "subscriber");
            consumer.setMessageListener(listener);
        } catch (JMSException ex) {
//            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
//            onException(ex);
//            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}