package com.hy.learn.base.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author Created by hy
 * @date on 2020/5/11 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DoctorBaseDTO extends UserBaseDTO{

    private String collection;

    private Integer setmealId;

    private boolean bindWx;

    private List<Integer> desease;

    private String worktime;

    private String icon;

    private boolean consultable;

    private boolean allowRenewalApplication;

    private boolean allowDepartmentAsst;

}
