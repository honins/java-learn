package com.hy.learn.base.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Created by hy
 * @date on 2020/5/18 11:34
 */
@Data
@AllArgsConstructor
@ToString
public class Apple implements Serializable {

    private String name;

    private int weight;

}
