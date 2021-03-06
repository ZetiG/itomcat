package com.zeti.test;

import com.zeti.itomcat.request.IRequest;
import com.zeti.itomcat.response.IResponse;
import com.zeti.itomcat.servlet.IServlet;

import java.io.IOException;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/24 3:19 下午
 */
public class TestServlet extends IServlet {

    @Override
    public void doGet(IRequest request, IResponse response) {
        try {
            response.write("Hello, test - GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(IRequest request, IResponse response) {
        try {
            response.write("Hello, test - POST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
