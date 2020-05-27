package com.syh.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * TakeClassPropertyUtil
 *  获取类的属性以及属性个数
 *  
 * @author HSY
 * @since 2020/05/07 13:31
 */
public class TakeClassPropertyUtil {
    /**
     *  获取指定类的所有成员变量的总数
     * @param obj   指定类
     * @return  int
     */
    public static int getPropertiesTotal(Object obj) {
        return obj.getClass().getDeclaredFields().length;
    }

    /**
     * 获取指定类的成员变量名
     * @param obj   指定类
     * @return  List<String>
     */
    public static List<String> takePropertiesName (Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> properties = new ArrayList<String>();
        for (Field field : fields) {
            properties.add(field.getName());
        }
        return properties;
    }
}
