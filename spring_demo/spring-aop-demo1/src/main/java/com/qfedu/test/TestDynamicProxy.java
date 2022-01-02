package com.qfedu.test;

import com.qfedu.dao.*;
import com.qfedu.proxy.CGLibDynamicProxy;

public class TestDynamicProxy {

    //JDK动态代理
//    public static void main(String[] args) {
//
//        //被代理对象(必须实现了某个接口)
//        BookDAOImpl bookDAO = new BookDAOImpl();
//
//        //proxy就是产生的代理对象,可以强转成被代理对象实现的接口类型
//        GeneralDAO proxy = (GeneralDAO) new JDKDynamicProxy(bookDAO).getProxy();
//
//        //使用代理对象调用方法，不会直接进入到被代理类，而是进入了创建代理对象时指定的InvocationHandler类中的invoke方法
//        //调用的方法作为参数传递给了invoke
//        proxy.insert();
//
//    }

    //CGLib动态代理
//    public static void main(String[] args) {
//        //创建被代理对象
//        StudentDAOImpl studentDAO = new StudentDAOImpl();
//
//        CGLibDynamicProxy cGLibDynamicProxy = new CGLibDynamicProxy(studentDAO);
//
//        //代理对象实际上是被代理对象的子类，因此可以强转为被代理对象类型
//        StudentDAOImpl proxy = (StudentDAOImpl) cGLibDynamicProxy.getProxy();
//
//        proxy.update();
//
//    }

}
