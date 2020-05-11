package com.syh.util.test;

import com.syh.util.TakeRandomNumUtil;
import org.junit.Test;

/**
 * TakeRandomNumUtilTest
 *
 * @author HSY
 * @since 2020/05/11 13:23
 */
public class TakeRandomNumUtilTest {
    @Test
    public void getNumTest () {
        for (int i = 0; i < 100; i++) {
            System.out.println("TakeRandomNumUtil.getNum(1); = " + TakeRandomNumUtil.getNum(10));
        }
    }
}
