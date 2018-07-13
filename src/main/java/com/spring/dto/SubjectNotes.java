package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject_notes")

public class SubjectNotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_name_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public SubjectNotes() {
    }

    public SubjectNotes(Subject subject, Equipment equipment) {
        this.subject = subject;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "SubjectNotes{" +
                "id=" + id +
                ", subject=" + subject +
                ", equipment=" + equipment +
                '}';
    }
}
