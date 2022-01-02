package com.qfedu.test;

import com.qfedu.dao.BookDAOImpl;
import com.qfedu.dao.StudentDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {

        //通过spring容器获取BookDAOImpl的对象，并调用方法
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDAOImpl bookDAO = (BookDAOImpl) context.getBean("bookDAO");
        //bookDAO.update();

        //如果要使用spring aop，调用切入点方法的对象必须通过Spring容器获取
        //如果一个类中的方法被声明为切入点并且织入了切点之后，通过spring容器获取到的对象是一个通过CGLib动态代理创建的代理对象
        //如果一个类中的方法没有被声明为切入点，通过spring容器获取到的对象就是这个类真实创建的对象
        //StudentDAOImpl studentDAO = (StudentDAOImpl) context.getBean("studentDAO");
        //studentDAO.delete(212);

        bookDAO.insert();

    }

}
