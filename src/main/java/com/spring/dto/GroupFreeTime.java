package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_free_time")

public class GroupFreeTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Group groupId;

    @ManyToOne
    @JoinColumn(name = "day_hour_id")
    private DayHours dayHoursId;
}
