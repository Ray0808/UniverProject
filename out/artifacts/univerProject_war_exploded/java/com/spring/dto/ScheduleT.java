package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "s_teacher")

public class ScheduleT implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours day_hour_id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "week_day")
    private WeekDay weekDay;

    public ScheduleT(){

    }
    public ScheduleT(DayHours day_hour_id, Teacher teacherId, WeekDay weekDay) {
        this.day_hour_id = day_hour_id;
        this.teacherId = teacherId;
        this.weekDay = weekDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayHours getDayHoursId() {
        return day_hour_id;
    }

    public void setDayHoursId(DayHours dayHoursId) {
        this.day_hour_id = dayHoursId;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "ScheduleT{" +
                "id=" + id +
                ", dayHoursId=" + day_hour_id +
                ", teacherId=" + teacherId +
                ", weekDay=" + weekDay +
                '}';
    }
}

