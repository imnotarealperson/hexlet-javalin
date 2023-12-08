package org.example.hexlet;

import io.javalin.Javalin;
import org.eclipse.jetty.util.StringUtil;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello", ctx -> ctx.result(String.format("Hello, %s!", !StringUtil.isBlank(ctx.queryParam("name"))
                                                                ? ctx.queryParam("name")
                                                                : "World")));

        app.start(7070); // Стартуем веб-сервер
    }
}