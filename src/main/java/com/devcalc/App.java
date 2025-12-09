package com.devcalc;

import com.devcalc.service.CalculatorService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class App {

    public static void main(String[] args) {
        int port = 7000;

        CalculatorService calculatorService = new CalculatorService();

        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        });

        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
            ctx.result("{\"error\":\"" + e.getMessage() + "\"}");
        });

        app.get("/", ctx -> ctx.result("{\"status\":\"DevCalc API - OK\"}"));

        app.get("/add", ctx -> {
            double a = getQueryParamAsDouble(ctx, "a");
            double b = getQueryParamAsDouble(ctx, "b");
            double result = calculatorService.add(a, b);
            ctx.result(jsonResult(result));
        });

        app.get("/subtract", ctx -> {
            double a = getQueryParamAsDouble(ctx, "a");
            double b = getQueryParamAsDouble(ctx, "b");
            double result = calculatorService.subtract(a, b);
            ctx.result(jsonResult(result));
        });

        app.get("/multiply", ctx -> {
            double a = getQueryParamAsDouble(ctx, "a");
            double b = getQueryParamAsDouble(ctx, "b");
            double result = calculatorService.multiply(a, b);
            ctx.result(jsonResult(result));
        });

        app.get("/divide", ctx -> {
            double a = getQueryParamAsDouble(ctx, "a");
            double b = getQueryParamAsDouble(ctx, "b");
            double result = calculatorService.divide(a, b);
            ctx.result(jsonResult(result));
        });

        app.start(port);
    }

    private static double getQueryParamAsDouble(Context ctx, String name) {
        String value = ctx.queryParam(name);
        if (value == null) {
            throw new IllegalArgumentException("Query parameter '" + name + "' is required.");
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Query parameter '" + name + "' must be a valid number.");
        }
    }

    private static String jsonResult(double result) {
        return "{\"result\":" + result + "}";
    }
}
