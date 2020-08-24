package com.zeti.itomcat.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description: request
 *
 * @author Zeti
 * @date 2020/8/24 2:43 下午
 */
public class IRequest {
    private static final Logger logger = LoggerFactory.getLogger(IRequest.class);

    /**
     * 请求url
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    public IRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
        }
        // HTTP请求协议:首行的内容依次为：请求方法、请求路径以及请求协议及其对应版本号
        // GET /index HTTP/1.1        取出HTTP请求协议的首行
        String httpHead = httpRequest.split("\n")[0];
        logger.info(httpHead);

        //按照空格进行分割，第一个是请求的方法
        method = httpHead.split("\\s")[0];

        //按照空格进行分割，第二个是请求的路径
        url = httpHead.split("\\s")[1];
        logger.info(this.toString());

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "IRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
