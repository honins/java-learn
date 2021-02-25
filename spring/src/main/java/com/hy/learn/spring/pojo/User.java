package com.hy.learn.spring.pojo;

import java.util.Date;

/**
 * @author Created by hy
 * @date on 2021/2/23 14:47
 */
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Date birthDate;

    public User() {
    }

    public User(Integer id, String name, Integer age, Date birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
