package com.syh.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HSY
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@XmlRootElement(name = "information")
public class BaseOrgInfo {

    private String orgCode;
    private String orgName;
    private String orgClass;
    private String addr;
    private String gradeCode;
    private Integer bed;
    private String tel;
    private Boolean topFlag;
    private String province;
    private String city;
    public BaseOrgInfo() {
        super();
    }
}