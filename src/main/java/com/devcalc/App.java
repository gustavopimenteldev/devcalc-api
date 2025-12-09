package com.devcalc;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        int port = 7000;

        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "text/plain";
        });

        app.get("/", ctx -> ctx.result("DevCalc API - OK"));

        app.start(port);
    }
}
