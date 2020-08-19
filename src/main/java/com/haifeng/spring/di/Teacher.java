package com.haifeng.spring.di;

import java.util.*;

/**
 * @author haifeng
 * @date 2020-07-07 22:14
 */
public class Teacher {

    private Integer tid;

    private String name;

    private List<String> cls;

    // 属性名称不规范，自动生成的getter 、 setter方法无法正常使用
    /*private List<Student> sList;
    public List<Student> getsList() {
        return sList;
    }
    public void setsList(List<Student> sList) {
        this.sList = sList;
    }*/
    private List<Student> students;

    // 老师的爱好
    private String[] fancys;

    // 上级领导
    private Map<String, String> bossMap;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", cls=" + cls +
                ", students=" + students +
                ", fancys=" + Arrays.toString(fancys) +
                ", bossMap=" + bossMap +
                '}';
    }

    public Map<String, String> getBossMap() {
        return bossMap;
    }

    public void setBossMap(Map<String, String> bossMap) {
        this.bossMap = bossMap;
    }

    public String[] getFancys() {
        return fancys;
    }

    public void setFancys(String[] fancys) {
        this.fancys = fancys;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public List<String> getCls() {
        return cls;
    }

    public void setCls(List<String> cls) {
        this.cls = cls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
