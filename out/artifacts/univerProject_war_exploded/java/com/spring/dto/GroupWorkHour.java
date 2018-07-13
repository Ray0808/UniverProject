package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_work_hour")

public class GroupWorkHour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours dayHoursId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    @ManyToOne
    @JoinColumn(name = "week_day")
    private WeekDay weekDay;

    public GroupWorkHour() {
    }

    public GroupWorkHour(DayHours dayHoursId, Group groupId, WeekDay weekDay) {
        this.dayHoursId = dayHoursId;
        this.groupId = groupId;
        this.weekDay = weekDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayHours getDayHoursId() {
        return dayHoursId;
    }

    public void setDayHoursId(DayHours dayHoursId) {
        this.dayHoursId = dayHoursId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "GroupWorkHour{" +
                "id=" + id +
                ", dayHoursId=" + dayHoursId +
                ", groupId=" + groupId +
                ", weekDay=" + weekDay +
                '}';
    }
}
