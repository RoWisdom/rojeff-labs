package com.rojeff.labs;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class HelloWorldTest {
    
    String address = "http://localhost:8080/cxf-labs-server/HelloWorld";

    @Test
    public void testSayHello() {
        JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
        bean.getInInterceptors().add(new LoggingInInterceptor());
        bean.getInFaultInterceptors().add(new LoggingOutInterceptor());
        bean.setServiceClass(HelloWorld.class);
        bean.setAddress(address);
        HelloWorld helloWorldService = (HelloWorld) bean.create();
        System.out.println(helloWorldService.sayHello("luoxinyu"));
    }

}
