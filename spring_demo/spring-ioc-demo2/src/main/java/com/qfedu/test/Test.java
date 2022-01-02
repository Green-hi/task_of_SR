package com.qfedu.test;

import com.qfedu.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Student student = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        System.out.println(student);
        System.out.println(student2);

    }

}
