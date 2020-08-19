package com.haifeng.ioc.life;

/**
 * @author haifeng
 * @date 2020-07-14 23:49
 */
public class Person {

    private Integer id;

    private String sex;

    private String name;

    public Person() {
        System.out.println("One: 创建对象");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("Two: 依赖注入");
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("Three: 初始化");
    }

    @Override
    public String toString() {
        return "Four: Person{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void destroy(){
        System.out.println("Five: 销毁");
    }
}
