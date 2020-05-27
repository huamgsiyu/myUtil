package com.syh.xml;

import com.syh.entity.BaseOrgInfo;
import com.syh.entity.Result;
import com.syh.xml.util.XmlUtil;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultTest
 *
 * @author HSY
 * @since 2020/05/27 12:41
 */
public class ResultTest {
    @Test
    public void resultTest () throws JAXBException {
        String xmlStr = XmlUtil.convertBeanToXmlStr(loadResult());
        System.out.println("Object -> xmlStr");
        System.out.println(xmlStr);

        System.out.println();
        Result result = XmlUtil.convertXmlStrToObject(new Result(), xmlStr);
        System.out.println("xmlStr -> Object");
        System.out.println(result);
    }

    private static Result loadResult () {
        Result result = new Result();
        result.setResult(true);
        result.setErrorInfo("成功");
        BaseOrgInfo baseOrgInfo = loadOrgInfo();
        result.setInformation(baseOrgInfo);
        return result;
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
