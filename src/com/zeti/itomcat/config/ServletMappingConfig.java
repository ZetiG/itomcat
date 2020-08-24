package com.zeti.itomcat.config;

import com.zeti.itomcat.servlet.IServletMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  (用一句话描述该文件做什么)
 *
 * @author Zeti
 * @date 2020/8/24 3:00 下午
 */
public class ServletMappingConfig {

    public static List<IServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new IServletMapping("index", "/index", "com.zeti.test.IndexServlet"));
        servletMappingList.add(new IServletMapping("test", "/test", "com.zeti.test.TestServlet"));
    }
}
