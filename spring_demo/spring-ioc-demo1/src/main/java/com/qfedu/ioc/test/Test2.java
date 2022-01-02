package com.qfedu.ioc.test;

import com.qfedu.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        //通过spring容器创建对象
        //1.初始化spring容器,加载spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.通过spring容器获取对象
        Student student2 = (Student) context.getBean("student");
        System.out.println(student2);

        Map<String,Object> maps = student2.getMaps();
        Set<Map.Entry<String, Object>> entries = maps.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}

