package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="room_time")

public class RoomFreeTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours dayHoursId;

    public RoomFreeTime() {
    }

    public RoomFreeTime(Room roomId, DayHours dayHoursId) {
        this.roomId = roomId;
        this.dayHoursId = dayHoursId;
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

    public DayHours getDayHoursId() {
        return dayHoursId;
    }

    public void setDayHoursId(DayHours dayHoursId) {
        this.dayHoursId = dayHoursId;
    }
}
