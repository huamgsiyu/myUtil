package com.syh.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author HSY
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
public class Result {
    private Boolean result;
    private String errorInfo;
    /**
     * 如果是Object
     */
    private BaseOrgInfo information;

    public Result() {
        super();
    }
}
