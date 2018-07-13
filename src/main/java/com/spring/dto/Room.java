package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")

public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomTypeId;

    @ManyToOne
    @JoinColumn(name = "corpus_id")
    private Corpus corpusId;

    @Column(name = "resp_emp_id")
    private int respId;

    public Room(String name, Integer capacity, RoomType roomTypeId, Corpus corpusId, int respId) {
        this.name = name;
        this.capacity = capacity;
        this.roomTypeId = roomTypeId;
        this.corpusId = corpusId;
        this.respId = respId;
    }

    public Room(){

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomType getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(RoomType roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Corpus getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(Corpus corpusId) {
        this.corpusId = corpusId;
    }

    public int getRespId() {
        return respId;
    }

    public void setRespId(int respId) {
        this.respId = respId;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", roomTypeId=" + roomTypeId +
                ", corpusId=" + corpusId +
                ", respId=" + respId +
                '}';
    }
}
