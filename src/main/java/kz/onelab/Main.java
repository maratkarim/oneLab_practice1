package kz.onelab;

import kz.onelab.service.ServiceAll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        ServiceAll serviceAll = context.getBean(ServiceAll.class);

        serviceAll.getAllBooks().forEach(System.out::println);
        serviceAll.getAllLibraries().forEach(System.out::println);
        serviceAll.getAllCity().forEach(System.out::println);
    }
}