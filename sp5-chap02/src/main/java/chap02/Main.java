package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g = ctx.getBean("greeter",Greeter.class);
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("스프링");
        System.out.println(msg);
        //빈 객체는 싱글톤 범위를 갖는다.
        System.out.println(g==g1);
        ctx.close();
    }
}
