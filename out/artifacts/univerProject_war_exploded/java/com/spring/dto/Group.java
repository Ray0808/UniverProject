package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "groups")

public class Group implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
		
	@Column(name = "name")
	private String name;

	@Column(name = "number_of_students")
	private int numberOfStudents;

	@Column(name = "smena_name")
	private Integer smenaId;

	@ManyToOne
	@JoinColumn(name="stream_id")
	private Stream streamId;

	public Group(String name, int numberOfStudents, Integer smenaId, Stream streamId) {
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.smenaId = smenaId;
		this.streamId = streamId;
	}

	public Group(){

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

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public Integer getSmenaId() {
		return smenaId;
	}

	public void setSmenaId(Integer smenaId) {
		this.smenaId = smenaId;
	}

	public Stream getStreamId() {
		return streamId;
	}

	public void setStreamId(Stream streamId) {
		this.streamId = streamId;
	}

	@Override
	public String toString() {
		return name;
	}
}
