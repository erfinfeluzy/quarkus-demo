package com.erfinfeluzy.demo.quarkus;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class HelloService {

	@ConfigProperty(name = "greeting")
	private String greeting;
    
    public String politeGreeting(String name) {
        return greeting + ", " + name;
    }
}
