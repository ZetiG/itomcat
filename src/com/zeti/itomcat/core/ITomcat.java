package com.zeti.itomcat.core;

import com.zeti.itomcat.config.ServletMappingConfig;
import com.zeti.itomcat.request.IRequest;
import com.zeti.itomcat.response.IResponse;
import com.zeti.itomcat.servlet.IServlet;
import com.zeti.itomcat.servlet.IServletMapping;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: tomcat
 * Tomcat的处理流程：把URL对应处理的Servlet关系形成，解析HTTP协议，封装请求/响应对象，
 * 利用反射实例化具体的Servlet进行处理即可。
 *
 * @author Zeti
 * @date 2020/8/24 3:10 下午
 */
public class ITomcat {

    private Integer port = 8080;     //定义8080端口

    private Map<String, String> urlServletMapping = new HashMap<>();    //存储url和对应的类

    public ITomcat(Integer port) {
        super();
        this.port = port;
    }

    public static void main(String[] args) {
        ITomcat iTomcat = new ITomcat(8080);
        iTomcat.start();
    }

    @SuppressWarnings("resource")
    public void start() {
        initServletMapping();

        try {
            ServerSocket serverSocket = null;     //实例化一个 ServerSocket 对象，表示通过服务器上的端口通信
            serverSocket = new ServerSocket(port);
            System.out.println("itomcat is starting...");
            while (true) {

                //服务器调用 ServerSocket 类的 accept()
                Socket socket = serverSocket.accept();

                // 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                IRequest myRequest = new IRequest(inputStream);
                IResponse myResponse = new IResponse(outputStream);

                dispatch(myRequest, myResponse);

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //初始化映射
    public void initServletMapping() {
        for (IServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMapping.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    //分发请求
    @SuppressWarnings("unchecked")
    public void dispatch(IRequest iRequest, IResponse iResponse) {
        String clazz = urlServletMapping.get(iRequest.getUrl());

        try {
            Class<IServlet> iServletClass = (Class<IServlet>) Class.forName(clazz);
            IServlet iServlet = iServletClass.newInstance();
            iServlet.service(iRequest, iResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
