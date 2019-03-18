package com.mytomcat;

import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GK_LZS  ON 2019/3/18
 */
public class MyTomcat {
    private  int port = 8080;

    private Map<String,String> urlServlerMap = new HashMap<String, String>();

    public MyTomcat(int port){
        this.port = port;
    }
    /**
     * start方法     */
    public void start(){
        //初始化url 与对应处理的servler关系
        initServlerMappering();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start...");
            while(true){
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest request = new MyRequest(inputStream);

                MyResponse response = new MyResponse(outputStream);
                response.write("dddddddd");
                //请求分发
                dispath(request,response);
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServlerMappering(){
        for(ServletMapping servletMapping: ServletMappingConfig.servletMappingList){
            urlServlerMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    private void dispath(MyRequest request,MyResponse response){
        String clazz = urlServlerMap.get(request.getUrl());
        //反射
        try {
            Class<BaseMyServlet> baseMyServletClass = (Class<BaseMyServlet>) Class.forName(clazz);
            BaseMyServlet baseMyServlet = baseMyServletClass.newInstance();
            baseMyServlet.service(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat(8080).start();
    }
}
