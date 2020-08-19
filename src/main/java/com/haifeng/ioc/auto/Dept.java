package com.haifeng.ioc.auto;

/**
 * @author haifeng
 * @date 2020-07-19 17:33
 */
public class Dept implements DeptI{

    private Integer did;

    private String dname;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
