package com.test.ventaapp.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.ventaapp.source.VentaService;

public class TestJms {
    public static void main(String[] args) {
       
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/root-context.xml");
        VentaService ventaService = (VentaService) ctx.getBean("ventaService");
       
        for(int i =1; i<=5; i++)
            ventaService.sendVenta(1+i, 10.0D+i);
    }
}