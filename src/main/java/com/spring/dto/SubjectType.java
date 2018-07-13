package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subject_type")

public class SubjectType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "equopment_id")
    private Equipment equipmentId;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    public SubjectType() {
    }

    public SubjectType(Subject subjectId, Equipment equipmentId, Room roomId) {
        this.subjectId = subjectId;
        this.equipmentId = equipmentId;
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }


    @Override
    public String toString() {
        return "SubjectType{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", equipmentId=" + equipmentId +
                ", roomId=" + roomId +
                '}';
    }
}
