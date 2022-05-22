package com.lyrmrk.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.lyrmrk.controller","com.lyrmrk.service"})
@EntityScan("com.lyrmrk.entity")
@EnableJpaRepositories("com.lyrmrk.repository")
public class LyrmrkinternshiptaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyrmrkinternshiptaskApplication.class, args);
    }

}
