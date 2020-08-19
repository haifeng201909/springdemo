package com.haifeng.spring.di;

/**
 * @author haifeng
 * @date 2020-07-07 22:13
 */
public class Student {

    private Integer id;

    private String name;

    private Double score;

    private Teacher teacher;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(Integer id, String name, Double score, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", teacher=" + teacher +
                '}';
    }
}
