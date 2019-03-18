package com.mytomcat;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GK_LZS  ON 2019/3/18
 * 在servlet开发中，会在web.xml中通过<servlet></servlet>和<servlet-mapping></servlet-mapping>来进行指定哪个URL交给哪个servlet进行处理。
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
    static {
        servletMappingList.add(new ServletMapping("findFood", "/food", "com.mytomcat.FindFoodServlet"));
        servletMappingList.add(new ServletMapping("helloWord", "/helloword", "com.mytomcat.HelloWorldServlet"));
    }

}
