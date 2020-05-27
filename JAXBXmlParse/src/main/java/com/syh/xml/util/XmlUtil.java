package com.syh.xml.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XmlUtil
 *
 * @author HSY
 * @since 2020/05/27 10:21
 */
public class XmlUtil {

    /**
     * 将String格式的XML转换成对象
     *
     * @param t                 要转为的类型
     * @param xmlStr            String格式的XML
     * @return                  Object
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertXmlStrToObject(T t, String xmlStr) throws JAXBException {
        /* 获得 JAXBContext 类的新实例。参数为类的地址 */
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        /* 创建一个可以用来将 XML 数据转换为 java 内容树的 Unmarshaller 对象。*/
        Unmarshaller um = context.createUnmarshaller();
        /* 创建一个StringReader将xml报文转成流*/
        StringReader sr = new StringReader(xmlStr);
        /* 调用unmarshal进行转换，并把Object类型强转为调用者的类型*/
        t = (T) um.unmarshal(sr);
        return t;
    }

    /**
     * 将String格式的XML转为object，object支持泛型
     *
     * @param clazz             Object
     * @param t                 泛型
     * @param xml               String格式的XML
     * @param <T>               泛型
     * @return                  clazz类
     * @throws JAXBException    解析XML过程可能出现的异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertXmlStrToObject(Class clazz, T t, String xml) throws JAXBException {
        /* 获得 JAXBContext 类的新实例。参数为类的地址 */
        JAXBContext context = JAXBContext.newInstance(t.getClass(),clazz);
        /* 创建一个可以用来将 XML 数据转换为 java 内容树的 Unmarshaller 对象 */
        Unmarshaller um = context.createUnmarshaller();
        /* 创建一个StringReader将xml报文转成流 */
        StringReader sr = new StringReader(xml);
        /* 调用unmarshal进行转换，并把Object类型强转为调用者的类型 */
        t = (T) um.unmarshal(sr);
        return t;
    }

    public static <T> String convertBeanToXmlStr(T t) throws JAXBException {
        /* 获得 JAXBContext 类的新实例。参数为类的地址 */
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        /* 创建一个可以用来将 java 内容树转换为 XML 数据的 Marshaller 对象。 */
        Marshaller m = context.createMarshaller();
        /* 创建一个StringWriter流将接收到的对象流写入xml字符串 */
        StringWriter sw = new StringWriter();
        /*调用marshal方法进行转换 */
        m.marshal(t, sw);
        return sw.toString();
    }

    /**
     * 将Object转为XMl格式的String
     *
     * @param clazz             要转为的类型
     * @param t                 泛型对象
     * @param <T>               泛型
     * @return                  String
     * @throws JAXBException    解析XML过程可能出现的异常
     */
    public static <T> String convertBeanToXmlStr(Class clazz, T t) throws JAXBException {
        /* 获得 JAXBContext 类的新实例。参数为类的地址 */
        JAXBContext context = JAXBContext.newInstance(t.getClass(), clazz);
        /* 创建一个可以用来将 java 内容树转换为 XML 数据的 Marshaller 对象。 */
        Marshaller m = context.createMarshaller();
        /* 创建一个StringWriter流将接收到的对象流写入xml字符串 */
        StringWriter sw = new StringWriter();
        /*调用marshal方法进行转换 */
        m.marshal(t,sw);
        return sw.toString();
    }
}
