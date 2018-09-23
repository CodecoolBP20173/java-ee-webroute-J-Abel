package com.codecool.kucsma.java_ee_webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class OwnHandler implements HttpHandler {
    public OwnHandler() {
    }

    public static void init(HttpServer server) {
        for (Method method : OwnHandler.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                String path = method.getAnnotation(WebRoute.class).path();
                server.createContext(path, new OwnHandler());
            }
        }
    }

    @WebRoute(path = "/here")
    public void handle(HttpExchange request) throws IOException {
        String response = "Here I am";
        request.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = request.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
