package com.qfedu.ioc.bean;

import java.util.*;

public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
    private Date entranceTime;  //入学日期
    private Clazz clazz;
    private List<Book> hobbies;
    private Set<String> sets;
    private Map<String,Object> maps;
    private Properties properties;  //map的一种，键值对只能是String类型

    public Student() {
    }

    public Student(String stuNum) {
        this.stuNum = stuNum;
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
                ", hobbies=" + hobbies +
                ", sets=" + sets +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Book> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Book> hobbies) {
        this.hobbies = hobbies;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String sutNum) {
        this.stuNum = sutNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }
}
