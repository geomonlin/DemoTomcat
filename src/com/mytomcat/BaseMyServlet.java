package com.mytomcat;

/**
 * Created by GK_LZS  ON 2019/3/18
 * 提供Servlet常见的doGet/doPost/service方法。
 */
public abstract class BaseMyServlet {
    public abstract  void doGet(MyRequest request,MyResponse response);

    public abstract void doPost(MyRequest request,MyResponse response);

    /**
     * 执行doGet,doPost请求
     * @param request
     * @param response
     */
    public void service(MyRequest request,MyResponse response){
        //这里注意POST /GET在前
        if("POST".equalsIgnoreCase(request.getMethod())){
            doPost(request,response);
        } else if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }
    }
}
