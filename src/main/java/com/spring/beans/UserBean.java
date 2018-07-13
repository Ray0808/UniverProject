package com.spring.beans;

import com.spring.dto.*;

import java.math.BigDecimal;
import java.util.List;

public interface UserBean {

    List<Subject> getAllSubjects();

    List<SubjectType> getDividedSubject();


    List<Teacher> getAllTeachers();
    List<Teacher> getTeacherByPriority();
    List<TeacherFreeTime> getTeacherFreeTime();


    List<ScheduleT> getTeacherWorkTime();

    List<Room> getAllRooms();
    List<Room> getRoomsByNotes();
    List<Room> getRoomsbyNotesAndFreeTime();
    List<Room> getLectureRoom();
    List<Room> getLabAndPracRoom(Filtr f);

    List<Group> getAllGroups();
    List<Group> getAllGroupInSchedule();

    List<Filtr> getAllFiltr();
    List<Filtr> getStreamLecture();
    List<Filtr> getTeacherBySubject();
    List<Filtr> getPracSubject();

    Integer getNumberOfLectureByFiltr(Filtr f);
    Integer getPracAndLabNumByFiltr(Filtr f);

    List<WeekDay> getAllWeekDay();

    List<DayHours> getAllHour();

    List<StreamGroup> getGroupByStreamId(Group g);
    List<StreamGroup> getAllStreamGroup();

    List<Schedule> getAllSchedule();
    void insertSchedule(Schedule s);
    void addSchedule(Schedule s);

    boolean scheduleAlreadyHas(Room room, WeekDay weekDay, DayHours time);

    boolean scheduleAlreadyHas(Teacher teacher, Group group, WeekDay weekDay, DayHours time, Subject subject);
     boolean lectureAfterThisTime(Group group, Subject subject, WeekDay weekDay, DayHours time);
     boolean groupAlreadyHasNLectures(WeekDay weekDay, Group group, DayHours time, Room room);

     boolean scheduleAlreadyHasRoomByTime(Room room);
    Long getNumberOfStudentsByFilter(Filtr filtr);





}
