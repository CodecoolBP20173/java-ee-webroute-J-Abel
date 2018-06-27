package com.codecool.kucsma.java_ee_webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnHandler implements HttpHandler {
    @Override
    @WebRoute(path = "/here")
    public void handle(HttpExchange request) {

        try {
            Method method = Class.forName("com.codecool.kucsma.java_ee_webroute.Here").
                    getMethod("respForHere", HttpExchange.class);
            try {
                method.invoke(method, request);
                System.out.println("yeee");
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
