package com.syh.util.test;

import com.syh.util.TakeClassPropertyUtil;
import com.syh.util.test.pojo.Student;
import org.junit.Test;

import java.util.List;

/**
 * TakeClassPropertyUtilTest
 *
 * @author HSY
 * @since 2020/05/07 13:39
 */
public class TakeClassPropertyUtilTest {
    @Test
    public void getPropertiesTotal () {
        int propertiesTotal = TakeClassPropertyUtil.getPropertiesTotal(new Student());
        System.out.println("propertiesTotal = " + propertiesTotal);
    }

    @Test
    public void takePropertiesName () {
        List<String> names = TakeClassPropertyUtil.takePropertiesName(new Student());
        for (String name :
                names) {
            System.out.println("name = " + name);
        }
    }
}
