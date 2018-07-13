package com.spring.dto;

import javax.persistence.*;

@Entity
@Table(name = "teacher_free_time")
public class TeacherFreeTime {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours dayHoursId;

    public TeacherFreeTime() {
    }

    public TeacherFreeTime(Teacher teacherId, DayHours dayHoursId) {
        this.teacherId = teacherId;
        this.dayHoursId = dayHoursId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public DayHours getDayHoursId() {
        return dayHoursId;
    }

    public void setDayHoursId(DayHours dayHoursId) {
        this.dayHoursId = dayHoursId;
    }
}
