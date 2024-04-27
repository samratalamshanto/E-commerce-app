package com.example.demo_ecommerce_app.util;

import com.google.gson.Gson;

public class Utility {
    public static String ObjectToJson(Object object) {
        Gson gson = new Gson();
        try {
            String jsonDataInString = gson.toJson(object);
            return jsonDataInString;
        } catch (Exception e) {
            return "";
        }
    }

}
