package com.haifeng.ioc.auto;

import javax.swing.event.CaretEvent;

/**
 * @author haifeng
 * @date 2020-07-19 17:33
 */
public class Car extends CarExtend {

    private Integer cid;

    private String cname;

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
