package com.zeti.itomcat.servlet;

/**
 * Description: handler mapping
 *
 * @author Zeti
 * @date 2020/8/24 2:55 下午
 */
public class IServletMapping {

    private String handleName;

    private String url;

    private String clazz;

    public IServletMapping(String handleName, String url, String clazz) {
        this.handleName = handleName;
        this.url = url;
        this.clazz = clazz;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

}
