package com.hy.learn.base.subject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectTest {

    private static int x = 100;

    @Test
    public void test7(){
        SubjectTest subjectTest1 = new SubjectTest();
        subjectTest1.x++;
        SubjectTest subjectTest2 = new SubjectTest();
        subjectTest2.x++;
        SubjectTest subjectTest3 = new SubjectTest();
        subjectTest3.x++;
        SubjectTest.x--;
        System.out.println(x);
    }

    @Test
    public void test8(){
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1);
        System.out.println(var1==var2);
    }
    public static void doSomething(Integer integer){
        integer = new Integer(2);
    }

    @Test
    public void test9(){
        Subject.test9("");
    }

}