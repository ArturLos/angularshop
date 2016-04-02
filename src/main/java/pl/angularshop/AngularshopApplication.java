package pl.angularshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AngularshopApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AngularshopApplication.class, args);
    }

}
