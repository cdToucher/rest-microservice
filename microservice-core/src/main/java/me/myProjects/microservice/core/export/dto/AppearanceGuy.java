package me.myProjects.microservice.core.export.dto;

import com.univocity.parsers.annotations.Parsed;

public class AppearanceGuy {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getHow() {
        return how;
    }

    public void setHow(Long how) {
        this.how = how;
    }

    @Parsed(field = "姓名")
    private String name;

    @Parsed(field = "年龄")
    private int age;

    @Parsed(field = "性别")
    private String sex;

    @Parsed(field = "表里不一，利字当头")
    private String kind;

    @Parsed(field = "程度")
    private Long how;
}
