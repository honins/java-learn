package com.hy.learn.base.pojo.vo;

import com.hy.learn.base.pojo.dto.DoctorBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Created by hy
 * @date on 2020/5/11 10:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DoctorListItemVO extends DoctorBaseDTO {

    private boolean hadDepartmentAsst;

    private boolean showDepartmentAsst;

}
