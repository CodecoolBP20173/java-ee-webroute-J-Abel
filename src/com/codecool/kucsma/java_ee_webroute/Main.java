package com.codecool.kucsma.java_ee_webroute;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        //easy way
        server.createContext("/test", new MyHandler());

        //using reflection
        OwnHandler.init(server);

        server.setExecutor(null); // creates a default executor
        server.start();
    }



}

