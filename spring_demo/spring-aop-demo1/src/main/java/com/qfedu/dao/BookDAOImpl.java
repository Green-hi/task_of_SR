package com.qfedu.dao;

import com.qfedu.proxy.GeneralDAO;

public class BookDAOImpl/* implements GeneralDAO */{

    public void insert(){
        System.out.println("---insert book");
        //throw new NullPointerException();  //测试after-throwing
    }

    public void delete(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---delete book");
    }

    public void update(){
        System.out.println("---update book");
    }

}
