package tech.codinglink.bookms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "tech.codinglink.bookms.dao")
public class BookmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmsApplication.class, args);
    }

}
