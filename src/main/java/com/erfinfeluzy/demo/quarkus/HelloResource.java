package com.erfinfeluzy.demo.quarkus;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.panache.common.Sort;

@Path("/api")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("students")
    public List<Student> getAllStudents() {
    	
    	return Student.listAll(Sort.by("name").ascending());
    }
    
    @GET
    @Path("add/{name}")
    @Transactional
    public Student save(@PathParam String name) {
    	
    	System.out.println(name);
    	
    	Student student = new Student();
    	student.name = name;
    	student.persist();
    	
    	return student;
    }
    
}