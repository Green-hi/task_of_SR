package com.qfedu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

@Component
//@Scope(value = "prototype")  //默认是singleton
@Lazy(value = false)  //默认是true
public class Student {

    private String stuNum = "10001";
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date entranceTime;

    //@Resource  //属性自动装配注解二: 先byName，后byType，找不到报异常
    @Autowired(required = false)  //找不到类型匹配的就赋值为null
    private Clazz clazz;

    /**
     * ref引用自动装配
     */
    /*@Autowired
    public void setClazz(@Qualifier("clazz") Clazz clazz) {
        this.clazz = clazz;
    }*/


    public Student() {
        System.out.println("~~~~~~~~~student");
    }

    @PostConstruct
    public void init() {
        //初始化方法，在创建当前类对象时调用(在构造器执行后)，进行一些资源准备工作 在配置文件中声明init-method="init"
        System.out.println("~~~~~~~~~~~init");
    }

    @PreDestroy
    public void destroy() {
        //销毁方法，在spring容器销毁对象前调用，进行一些资源释放工作 在配置文件中声明destroy-method="destroy"
        System.out.println("~~~~~~~~~~~destroy");
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", entranceTime=" + entranceTime +
                ", clazz=" + clazz +
                '}';
    }
}
