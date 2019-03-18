package com.mytomcat;

/**
 * Created by GK_LZS  ON 2019/3/18
 * servlet配置
 * @author  linzesi
 */
public class ServletMapping {
    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servlerName,String url,String clazz){
        this.servletName = servlerName;
        this.url = url;
        this.clazz = clazz;
    }
    public void setServletName(String servletName) {
        this.servletName = servletName;
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
