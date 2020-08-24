package com.zeti.itomcat.response;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Description: response
 *
 * @author Zeti
 * @date 2020/8/24 2:43 下午
 */
public class IResponse {

    /**
     * 输出流
     */
    private OutputStream outputStream;

    public IResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    //将文本转换为字节流
    public void write(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")      //按照HTTP响应报文的格式写入
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html><head><link rel=\"icon\" href=\"data:;base64,=\"></head><body>")
                .append(content)          //将页面内容写入
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());      //将文本转为字节流
        outputStream.close();
    }

}
