package com.syh.xml;

import com.syh.entity.BaseOrgInfo;
import com.syh.entity.Result3;
import com.syh.xml.util.XmlUtil;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Result1Test
 *
 * @author HSY
 * @since 2020/05/27 12:45
 */
public class Result3Test {
    @Test
    public void resultTest3 () throws JAXBException {
        Result3 result3 = loadResult();
        String xmlStr = XmlUtil.convertBeanToXmlStr(BaseOrgInfo.class, result3);
        System.out.println("Object -> xmlStr");
        System.out.println(xmlStr);

        System.out.println();
        Result3 result = XmlUtil.convertXmlStrToObject(BaseOrgInfo.class, new Result3(), xmlStr);
        System.out.println("xmlStr -> Object");
        System.out.println(result);
    }

    private static Result3 loadResult () {
        Result3<BaseOrgInfo> result3 = new Result3<>();
        result3.setResult(true);
        result3.setErrorInfo("成功");
        List<BaseOrgInfo> baseOrgInfos = new ArrayList<>();
        BaseOrgInfo baseOrgInfo = loadOrgInfo();
        baseOrgInfos.add(baseOrgInfo);
        baseOrgInfos.add(baseOrgInfo);
        result3.setInformation(baseOrgInfos);
        return result3;
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
