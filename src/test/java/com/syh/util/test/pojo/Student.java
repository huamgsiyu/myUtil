package com.syh.util.test.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Setter;

/**
 * pojo
 *
 * @author HSY
 * @since 2020/05/07 13:20
 */
@Data
public class Student {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private String age;
}
