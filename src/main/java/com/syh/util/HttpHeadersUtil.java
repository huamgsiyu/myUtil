package com.syh.util;



import com.google.common.collect.Lists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * HttpHeadersUtil
 *
 * @author HSY
 * @since 2020/05/21 22:14
 */
public class HttpHeadersUtil {

    /**
     * HTTP的请求头
     * @return  HttpHeaders
     */
    public static HttpHeaders getHeader () {
        HttpHeaders headers = new HttpHeaders();

        // 实体头；发送端（客户端|服务器）发送的实体数据的数据类型
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        /* 请求头；发送端（客户端）希望接受的数据类型 */
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON_UTF8));

        return headers;
    }
}
