package com.syh.xml;

import com.syh.entity.BaseOrgInfo;
import com.syh.entity.Result;
import com.syh.entity.Result1;
import com.syh.xml.util.XmlUtil;
import org.junit.Test;

import javax.xml.bind.JAXBException;

/**
 * Result1Test
 *
 * @author HSY
 * @since 2020/05/27 12:45
 */
public class Result1Test {
    @Test
    public void resultTest1 () throws JAXBException {
        Result1 result1 = loadResult();
        String xmlStr = XmlUtil.convertBeanToXmlStr(BaseOrgInfo.class, result1);
        System.out.println("Object -> xmlStr");
        System.out.println(xmlStr);

        System.out.println();
        Result1 result = XmlUtil.convertXmlStrToObject(BaseOrgInfo.class, new Result1(), xmlStr);
        System.out.println("xmlStr -> Object");
        System.out.println(result);
    }

    private static Result1 loadResult () {
        Result1<BaseOrgInfo> result1 = new Result1<>();
        result1.setResult(true);
        result1.setErrorInfo("成功");
        BaseOrgInfo baseOrgInfo = loadOrgInfo();
        result1.setInformation(baseOrgInfo);
        return result1;
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
