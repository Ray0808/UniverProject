package com.spring.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Struct;

@Entity
@Table(name="filtr")
public class Filtr implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "stream_group_id")
    private StreamGroup streamGroupId;

    @Column(name="course")
    private String course;

    @Column(name = "semester")
    private String semester;

    @Column(name = "student_num")
    private Integer sudentNum;

    @Column(name = "credit_number")
    private Integer creditNumber;

    @Column(name = "lecture_number")
    private Integer lectureNumber;

    @Column(name = "practic_number")
    private Integer practicNumber;

    @Column(name = "lab_number")
    private Integer labNumber;

    @Column(name = "OSOJ")
    private Integer osoj;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chairId;

    @Column(name = "type_edu")
    private String typeEdu;

    public Filtr() {
    }

    public Filtr(Subject subjectId, StreamGroup streamGroupId, String course, String semester, Integer sudentNum, Integer creditNumber, Integer lectureNumber, Integer practicNumber, Integer labNumber, Integer osoj, Teacher teacherId, Chair chairId, String typeEdu) {
        this.subjectId = subjectId;
        this.streamGroupId = streamGroupId;
        this.course = course;
        this.semester = semester;
        this.sudentNum = sudentNum;
        this.creditNumber = creditNumber;
        this.lectureNumber = lectureNumber;
        this.practicNumber = practicNumber;
        this.labNumber = labNumber;
        this.osoj = osoj;
        this.teacherId = teacherId;
        this.chairId = chairId;
        this.typeEdu = typeEdu;
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

    public StreamGroup getStreamGroupId() {
        return streamGroupId;
    }

    public void setStreamGroupId(StreamGroup streamGroupId) {
        this.streamGroupId = streamGroupId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getSudentNum() {
        return sudentNum;
    }

    public void setSudentNum(Integer sudentNum) {
        this.sudentNum = sudentNum;
    }

    public Integer getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Integer creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Integer getLectureNumber() {
        return lectureNumber;
    }

    public void setLectureNumber(Integer lectureNumber) {
        this.lectureNumber = lectureNumber;
    }

    public Integer getPracticNumber() {
        return practicNumber;
    }

    public void setPracticNumber(Integer practicNumber) {
        this.practicNumber = practicNumber;
    }

    public Integer getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(Integer labNumber) {
        this.labNumber = labNumber;
    }

    public Integer getOsoj() {
        return osoj;
    }

    public void setOsoj(Integer osoj) {
        this.osoj = osoj;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Chair getChairId() {
        return chairId;
    }

    public void setChairId(Chair chairId) {
        this.chairId = chairId;
    }

    public String getTypeEdu() {
        return typeEdu;
    }

    public void setTypeEdu(String typeEdu) {
        this.typeEdu = typeEdu;
    }


}
