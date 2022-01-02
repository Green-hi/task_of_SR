package com.qfedu.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void method1(){
        System.out.println("~~~~~~~~~~~~~~~method1");
    }
    public void method2(){
        System.out.println("~~~~~~~~~~~~~~~method2");
    }
    public void method3(){
        System.out.println("~~~~~~~~~~~~~~~method3");
    }
    public void method4(){
        System.out.println("~~~~~~~~~~~~~~~method4");
    }

    //环绕通知的切点方法，必须遵循以下定义规则：
    //1、必须要有一个ProceedingJoinPoint类型的参数
    //2、必须有Object类型的返回值
    //3、在前后增强的业务逻辑之间执行Object o = joinPoint.proceed();
    //4、方法最后返回o
    public Object method5(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("~~~~~~~~~~~~~~~method5---before");
        Object o = joinPoint.proceed();  //表示切入点方法的执行
        System.out.println("~~~~~~~~~~~~~~~method5---after");
        return o;
    }

}
