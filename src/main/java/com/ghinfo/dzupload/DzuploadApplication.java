package com.ghinfo.dzupload;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableScheduling
public class DzuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzuploadApplication.class, args);
    }

}
