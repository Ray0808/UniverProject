package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "day_hours")
public class DayHours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "from_hour")
    private Time fromHour;

    @Column(name = "to_hour")
    private Time toHour;

    @Column(name = "time_period")
    private Time timePeriod;

    @Column(name = "smena")
    private Integer smena;

    public DayHours() {
    }

    public DayHours(Time fromHour, Time toHour, Time timePeriod) {
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.timePeriod = timePeriod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getFromHour() {
        return fromHour;
    }

    public void setFromHour(Time fromHour) {
        this.fromHour = fromHour;
    }

    public Time getToHour() {
        return toHour;
    }

    public void setToHour(Time toHour) {
        this.toHour = toHour;
    }

    public Time getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Time timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "DayHours{" +
                "id=" + id +
                ", fromHour=" + fromHour +
                ", toHour=" + toHour +
                ", timePeriod=" + timePeriod +
                '}';
    }
}
