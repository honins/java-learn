package com.hy.learn.base.polymorphic;

import lombok.Data;

/**
 * @author Created by hy
 * @date on 2020/5/19 10:12
 */
public class User implements IUser{

    private Integer id;

    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
