package com.hy.learn.base.exam;

import java.util.List;

/**
 * @author Created by hy
 * @date on 2020/7/9 9:41
 */
public class Menu {

    private int id;

    private String name;

    private int pid;

    private List<Menu> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(){

    }

    public Menu(int id, int pid) {
        this.id = id;
        this.pid = pid;
    }
}
