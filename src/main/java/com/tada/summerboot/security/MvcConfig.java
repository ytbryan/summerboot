package com.tada.summerboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		//Map the URL to a specific View (html) inside templates
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/error").setViewName("error");
		registry.addViewController("/product").setViewName("product");
		registry.addViewController("/every").setViewName("every-product");

	}
}
