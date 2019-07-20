package com.erfinfeluzy.demo.quarkus;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Student extends PanacheEntity  {

	@Column(unique = true)
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(length = 40, unique = true)
	public String name;

	
	/**  generated constructor  **/
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {}
	
	
	
}
