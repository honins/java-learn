package com.hy.learn.base.base;

/**
 * @author Created by hy
 * @date on 2020/5/29 9:06
 */
public class Extend {


    static class A {

        public void scan(){
            doScan();;
        }

        public void doScan(){
            System.out.println("A scan...");
        }
    }

    static class B  extends A{
        @Override
        public void doScan() {
            System.out.println("B scan...");
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.scan();
    }

}
