package com.yamman.xml.validator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class XmlValidatorApplication {
    
    public static void main(String[] args) {
       SpringApplication.run(XmlValidatorApplication.class, args);
    }

}
