package com.qfedu.proxy;

public class MyStaticProxy {

    /*
    * 静态代理，只能为特定的类（实现了特定接口的类）产生代理对象，不能代理任意类
    * */
    /*
    * 使用代理的好处：
    * 1、被代理类中只用关注核心业务的实现，将通用的管理型逻辑（事务管理、日志管理）和业务逻辑分离
    * 2、将通用的代码放在代理类中实现，提高了代码的复用性
    * 3、通过在代理类添加业务逻辑，实现对原有业务的扩展（增强）
    * */
    private GeneralDAO generalDAO;

    public MyStaticProxy(GeneralDAO generalDAO) {
        this.generalDAO = generalDAO;
    }

    public void insert(){
        begin();
        generalDAO.insert();
        commit();
    }

    public void delete(){
        begin();
        generalDAO.delete();
        commit();
    }

    public void update(){
        begin();
        generalDAO.update();
        commit();
    }

    long time1;
    long time2;
    private void begin(){
        time1 = System.currentTimeMillis();
        System.out.println("---开启事务");
    }

    private void commit(){
        System.out.println("---提交事务");
        time2 = System.currentTimeMillis();
        System.out.println(generalDAO.getClass()+"执行时间:"+(time2-time1-1)+"ms");
    }

}
