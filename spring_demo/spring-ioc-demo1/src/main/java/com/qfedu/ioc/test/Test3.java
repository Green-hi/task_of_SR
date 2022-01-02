package com.qfedu.ioc.test;

import com.qfedu.ioc.bean.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("~~~~~~~~~~饿汉lazy-init=\"false\"~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~懒汉lazy-init=\"true\"~~~~~~~~~~~");
        Book book1 = (Book) context.getBean("book");
        Book book2 = (Book) context.getBean("book");

        System.out.println(book1);
        System.out.println(book2);
    }

}
