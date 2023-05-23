package com.example.hellospring2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.swing.*;

@Configuration
@ComponentScan
public class Hellospring2Application {
	@Bean
	public ServletWebServerFactory servletWebServerFactory(){

		return new TomcatServletWebServerFactory();
	}

	@Bean
	public DispatcherServlet dispatcherServlet(){

		return new DispatcherServlet();
	}

	public static void main(String[] args) {
		SpringApplication.run(Hellospring2Application.class,args);
	}
}
