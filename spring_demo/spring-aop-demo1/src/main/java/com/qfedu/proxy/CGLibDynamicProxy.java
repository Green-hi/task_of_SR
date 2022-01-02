package com.qfedu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
* CGLib动态代理：通过创建被代理类的子类来产生代理对象，因此即使没有实现任何接口的类也可以通过CGLib产生代理对象
*
* CGLib动态代理不能为 final 类创建代理对象
* */

public class CGLibDynamicProxy implements MethodInterceptor {

    private Object obj;

    public CGLibDynamicProxy(Object obj) {
        this.obj = obj;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        begin();
        Object returnValue = method.invoke(obj,objects);  //通过反射调用被代理类的方法
        commit();
        return returnValue;
    }

    public void begin(){
        System.out.println("---------开启事务");
    }

    public void commit(){
        System.out.println("---------提交事务");
    }
}
