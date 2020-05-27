package com.syh.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author HSY
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root", namespace = "http://schemas.microsoft.com/2003/10/Serialization/")
public class Result3<T> {
    private Boolean result;
    private String errorInfo;

    /**
     * 如果是T
     */
    private List<T> information;

    public Result3() {
        super();
    }
}
