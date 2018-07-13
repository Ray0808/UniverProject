package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "smena")

public class Smena implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "smenaName")
    private String smenaName;

    public Smena() {
    }

    public Smena(String smenaName) {
        this.smenaName = smenaName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmenaName() {
        return smenaName;
    }

    public void setSmenaName(String smenaName) {
        this.smenaName = smenaName;
    }
}
