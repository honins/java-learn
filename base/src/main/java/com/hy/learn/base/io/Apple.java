package com.hy.learn.base.io;

import java.io.Serializable;

/**
 * @author Created by hy
 * @date on 2020/5/18 11:34
 */
public class Apple implements Serializable {

    private String name;

    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(){
        super();
    }

    public Apple(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
