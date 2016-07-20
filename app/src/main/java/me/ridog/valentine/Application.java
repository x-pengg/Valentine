package me.ridog.valentine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Tate on 2016/7/8.
 */

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application implements CommandLineRunner {

    public static void main(String[] args) throws Exception{
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    //程序首次启动调用
    public void run(String... args) throws Exception {

    }
}
