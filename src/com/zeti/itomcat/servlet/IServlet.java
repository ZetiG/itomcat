package com.zeti.itomcat.servlet;

import com.zeti.itomcat.request.IRequest;
import com.zeti.itomcat.response.IResponse;

/**
 * Description: Servlet
 *
 * @author Zeti
 * @date 2020/8/24 2:52 下午
 */
public abstract class IServlet {

    public void service(IRequest request, IResponse response) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            doPost(request, response);
        } else if (request.getMethod().equalsIgnoreCase("GET")) {
            doGet(request, response);
        }
    }

    public void doGet(IRequest request, IResponse response) {
    }

    public void doPost(IRequest request, IResponse response) {
    }

}
