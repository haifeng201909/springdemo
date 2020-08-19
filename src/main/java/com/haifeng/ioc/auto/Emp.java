package com.haifeng.ioc.auto;

/**
 * @author haifeng
 * @date 2020-07-19 17:32
 */
public class Emp {

    private Integer eid;

    private String ename;

    private CarExtend car;

    private DeptI dept;

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", car=" + car +
                ", dept=" + dept +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public CarExtend getCar() {
        return car;
    }

    public void setCar(CarExtend car) {
        this.car = car;
    }

    public DeptI getDept() {
        return dept;
    }

    public void setDept(DeptI dept) {
        this.dept = dept;
    }
}
