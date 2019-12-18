package com.hy.learn.base.stream;


import java.util.List;

public class Menu {
    // 主键，菜单id
    private int id;
    // 菜单名称
    private String name;
    // 菜单父id，根节点pid=0
    private int pid;
    // 下级菜单
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
}
