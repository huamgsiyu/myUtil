package com.syh.util.test;

import com.syh.util.HumpUnderlineTransformUtil;
import org.junit.Test;

/**
 * HumpUnderlineTransformUtilTest
 *
 * @author HSY
 * @since 2020/05/07 13:24
 */
public class HumpUnderlineTransformUtilTest {
    @Test
    public void underlineToHumpTest () {
        String s = "my_name";
        String result = HumpUnderlineTransformUtil.underlineToHump(s);
        System.out.println("result = " + result);
    }

    @Test
    public void humpToUnderlineTest () {
        String s = "myName";
        String result = HumpUnderlineTransformUtil.humpToUnderline(s);
        System.out.println("result = " + result);
    }
}
