package cn.stevekung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:spring-dubbo.xml"})
public class AyUserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AyUserServerApplication.class, args);
    }
}
