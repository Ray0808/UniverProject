package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject")

public class Subject implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "name")
	private String name;

	@Column(name = "divide")
	private boolean divideId;

	public Subject(String name, int i, Integer semester) {
	}
	public Subject(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}
}
