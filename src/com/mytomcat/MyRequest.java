package com.mytomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by GK_LZS  ON 2019/3/18
 * 封装请求对象
 * 通过输入流，对HTTP协议进行解析，拿到了HTTP请求头的方法以及URL。
 */
public class MyRequest {
    private String url;

    private String method;
    public MyRequest(InputStream inputStream) throws IOException{
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestBytes)) > 0){
            httpRequest = new String(httpRequestBytes, 0, length);
        }


        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setMethod(String method) {
        this.method = method;
    }
}
