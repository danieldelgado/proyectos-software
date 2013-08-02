package com.jms.helloworld.test;
import javax.jms.JMSException;  
  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
public class TestJMSListner  
{  
 public static void main(String[] args) throws JMSException  
 {  
  System.out.println("LISTNER STARTED");  
  ApplicationContext context = new ClassPathXmlApplicationContext(  
    new String[] { "/META-INF/spring/JMSConfig.xml" });  
 }  
}  