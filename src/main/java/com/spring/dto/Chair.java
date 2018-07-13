package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="chair")

public class Chair implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
