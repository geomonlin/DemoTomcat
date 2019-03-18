package com.mytomcat;

import java.io.IOException;

/**
 * Created by GK_LZS  ON 2019/3/18
 */
public class FindFoodServlet extends BaseMyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get food ====");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post food ====");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
