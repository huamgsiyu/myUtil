package com.syh.xml;

import com.syh.entity.BaseOrgInfo;
import com.syh.entity.Result1;
import com.syh.entity.Result2;
import com.syh.xml.util.XmlUtil;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Result2Test
 *
 * @author HSY
 * @since 2020/05/27 12:59
 */
public class Result2Test {
    @Test
    public void resultTest2 () throws JAXBException {
        Result2 result2 = loadResult();
        String xmlStr = XmlUtil.convertBeanToXmlStr(Result2.class, result2);
        System.out.println("Object -> xmlStr");
        System.out.println(xmlStr);

        System.out.println();
        Result2 result = XmlUtil.convertXmlStrToObject(new Result2(), xmlStr);
        System.out.println("xmlStr -> Object");
        System.out.println(result);
    }

    private static Result2 loadResult () {
        Result2 result2 = new Result2();
        result2.setResult(true);
        result2.setErrorInfo("成功");
        List<BaseOrgInfo> baseOrgInfos = new ArrayList<>();
        BaseOrgInfo baseOrgInfo = loadOrgInfo();
        baseOrgInfos.add(baseOrgInfo);
        baseOrgInfos.add(baseOrgInfo);
        result2.setInformation(baseOrgInfos);
        return result2;
    }

    private static BaseOrgInfo loadOrgInfo () {
        BaseOrgInfo baseOrgInfo = new BaseOrgInfo();
        baseOrgInfo.setOrgCode("11");
        baseOrgInfo.setOrgName("22");
        baseOrgInfo.setOrgClass("33");
        baseOrgInfo.setAddr("44");
        baseOrgInfo.setGradeCode("55");
        baseOrgInfo.setBed(66);
        baseOrgInfo.setTel("77");
        baseOrgInfo.setTopFlag(true);
        baseOrgInfo.setProvince("88");
        baseOrgInfo.setCity("99");
        return baseOrgInfo;
    }
}
