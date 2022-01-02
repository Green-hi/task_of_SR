package com.qfedu.ioc.bean;

public class Book {
    private int bookId;
    private String bookName;

    public void init() {
        //初始化方法，在创建当前类对象时调用(在构造器执行后)，进行一些资源准备工作 在配置文件中声明init-method="init"
        System.out.println("~~~~~~~~~~~init");
        this.bookId = 1;
        this.bookName = "default name";
    }

    public void destroy() {
        //销毁方法，在spring容器销毁对象前调用，进行一些资源释放工作 在配置文件中声明destroy-method="destroy"
        System.out.println("~~~~~~~~~~~destroy");
    }

    public Book() {
        System.out.println("~~~~~~~~~~book");
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /*@Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }*/
}
