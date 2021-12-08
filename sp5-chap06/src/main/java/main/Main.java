package main;

import config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Client;
import spring.Client2;

import java.io.IOException;

public class Main {

    private static AnnotationConfigApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client client = ctx.getBean("client",Client.class);
        client.send();
        Client2 client2 = ctx.getBean("client2", Client2.class);
        client2.send();
        ctx.close();
    }
}
