package com.hy.learn.base.polymorphic;

/**
 * @author Created by hy
 * @date on 2020/5/19 10:16
 */
public class Work {

    public void goWork(User user){
        System.out.println(user.getName()+" go work");
    }

    public static void main(String[] args) {
        Man man = new Man();
        man.setName("sad");
        Work work = new Work();
        work.goWork(man);
    }
}
