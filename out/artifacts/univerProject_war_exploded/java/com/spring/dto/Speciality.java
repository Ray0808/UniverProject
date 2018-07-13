package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "speciality")

public class Speciality implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chairId;

    @ManyToOne
    @JoinColumn(name = "corpus_id")
    private Corpus corpusId;

}
