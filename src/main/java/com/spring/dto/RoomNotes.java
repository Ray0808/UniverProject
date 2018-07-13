package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roomNotes")

public class RoomNotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "notes_id")
    private Equipment notesId;


    public RoomNotes() {
    }

    public RoomNotes(Room roomId, Equipment notesId) {
        this.roomId = roomId;
        this.notesId = notesId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Equipment getNotesId() {
        return notesId;
    }

    public void setNotesId(Equipment notesId) {
        this.notesId = notesId;
    }
}
