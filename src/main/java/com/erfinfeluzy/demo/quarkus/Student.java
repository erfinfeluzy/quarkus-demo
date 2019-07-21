package com.erfinfeluzy.demo.quarkus;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Student extends PanacheEntity  {

	public Long id;
	
	public String name;


	public Student findByName(String name) {
		return find("name", name).firstResult();
	}
	
	
}
