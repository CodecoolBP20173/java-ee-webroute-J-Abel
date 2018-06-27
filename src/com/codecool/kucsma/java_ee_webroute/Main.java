package com.codecool.kucsma.java_ee_webroute;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.createContext("/here", new OwnHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }



}

