package com.hy.learn.base.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Created by hy
 * @date on 2020/5/11 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserBaseDTO {

    private Integer uid;

    private String name;

    private String position;

    private Integer departmentId;

    private String departmentName;

    private Integer hospitalId;

    private Integer hospitalName;


}
