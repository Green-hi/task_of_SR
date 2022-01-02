package com.qfedu.ioc.test;

import com.qfedu.ioc.servlets.TestServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.通过spring容器获取对象
        TestServlet testServlet = (TestServlet) context.getBean("testServlet");
        testServlet.doGet();

    }
}
