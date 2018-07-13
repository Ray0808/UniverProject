package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schedule")

public class Schedule implements Serializable{
//0
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
//1
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;
//2
    @ManyToOne
    @JoinColumn(name = "week_day_id")
    private WeekDay weekDayId;
//3
    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours dayHoursId;
//4
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;
//5
//6
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;
//7
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    public Schedule() {
    }

    public Schedule(Group groupId, WeekDay weekDayId, DayHours dayHoursId, Room roomId,Subject subjectId, Teacher teacherId) {
        this.groupId = groupId;
        this.weekDayId = weekDayId;
        this.dayHoursId = dayHoursId;
        this.roomId = roomId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public WeekDay getWeekDayId() {
        return weekDayId;
    }

    public void setWeekDayId(WeekDay weekDayId) {
        this.weekDayId = weekDayId;
    }

    public DayHours getDayHoursId() {
        return dayHoursId;
    }

    public void setDayHoursId(DayHours dayHoursId) {
        this.dayHoursId = dayHoursId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", weekDayId=" + weekDayId +
                ", dayHoursId=" + dayHoursId +
                ", roomId=" + roomId +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                '}';
    }
}
