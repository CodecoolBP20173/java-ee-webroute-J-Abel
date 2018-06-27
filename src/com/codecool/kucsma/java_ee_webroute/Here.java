package com.codecool.kucsma.java_ee_webroute;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Here {
    public static void respForHere(HttpExchange request) throws IOException {
        String response = "Here I am";
        request.sendResponseHeaders(200, response.getBytes().length);
        OutputStream outputStream = request.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
