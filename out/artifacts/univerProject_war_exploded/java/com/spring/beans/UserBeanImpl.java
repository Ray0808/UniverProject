package com.spring.beans;

import com.spring.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UserBeanImpl implements UserBean {

    SessionFactory sessionFactory;
    //private EntityManager em;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subject = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
        Root root = query.from(Subject.class);
        subject = session.createQuery(query).list();
        session.close();

        return subject;
    }

    public List<Room> getAllRooms() {
        List<Room> room = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Room> query = builder.createQuery(Room.class);
        Root root = query.from(Room.class);
        room = session.createQuery(query).list();
        session.close();

        return room;
    }

    @Override
    public List<Room> getLectureRoom() {

        List<Room> list = new ArrayList<Room>();
        try {
            Session session = sessionFactory.openSession();
            list =  session.createQuery("SELECT r FROM com.spring.dto.Room r, com.spring.dto.Filtr f " +
                    "inner join com.spring.dto.StreamGroup sg on f.streamGroupId = sg.id " +
                    "inner join com.spring.dto.Group g on sg.groupId = g.id " +
                    "WHERE r.capacity >= g.numberOfStudents and r.roomTypeId = 1", Room.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Room> getLabAndPracRoom(Filtr f) {
        List<Room> list = new ArrayList<Room>();
        try {
            Session session = sessionFactory.openSession();
            list =  session.createQuery("SELECT r FROM com.spring.dto.Room r, com.spring.dto.Filtr f" +
                    "                   inner join com.spring.dto.StreamGroup sg on f.streamGroupId = sg.id " +
                    "                   inner join com.spring.dto.Group g on sg.groupId = g.id                   " +
                    "                   inner join com.spring.dto.Subject s on  f.subjectId = s.id" +
                    "                   inner JOIN com.spring.dto.SubjectNotes sn on s.id=sn.subject" +
                    "                    where" +
                    "                   r.capacity > g.numberOfStudents and  f.streamGroupId=:group and f.subjectId=:subject " +
                    "                   and ( r.roomTypeId = 2 or r.roomTypeId=5)", Room.class).
                    setParameter("group",f.getStreamGroupId()).
                    setParameter("subject",f.getSubjectId()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Teacher> getAllTeachers() {

        List<Teacher> teachers = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = builder.createQuery(Teacher.class);
        Root root = query.from(Teacher.class);
        teachers = session.createQuery(query).list();
        session.close();

        return teachers;
        // return em.createQuery("select s from Teacher s", Teacher.class).getResultList();
    }

    public List<Teacher> getTeacherByPriority() {

        List<Teacher> teacherList = new ArrayList<Teacher>();
        try {
            Session session = sessionFactory.openSession();
            //Query query = session.createQuery("select fio from teachers ORDER BY priority DESC");
            //teacherList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    public List<ScheduleT> getTeacherWorkTime() {

        List<ScheduleT> teachers = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<ScheduleT> query = builder.createQuery(ScheduleT.class);
        Root root = query.from(ScheduleT.class);
        teachers = session.createQuery(query).list();
        session.close();

        return teachers;
    }

    public List<TeacherFreeTime> getTeacherFreeTime() {

        List<TeacherFreeTime> free = new ArrayList<TeacherFreeTime>();
        try {
            Session session = sessionFactory.openSession();
            free =  session.createQuery("select t from TeacherFreeTime t", TeacherFreeTime.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return free;
    }

    public List<Group> getAllGroups() {
        List<Group> groups = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Group> query = builder.createQuery(Group.class);
        Root root = query.from(Group.class);
        groups = session.createQuery(query).list();
        session.close();

        return groups;
    }

    @Override
    public List<Group> getAllGroupInSchedule() {
        List<Group> list = new ArrayList<Group>();
        try {
            Session session = sessionFactory.openSession();
            list =  session.createQuery("select distinct gr from com.spring.dto.Schedule sched " +
                    "left join com.spring.dto.Group gr on gr.id=sched.groupId", Group.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Filtr> getAllFiltr() {
        List<Filtr> filtr = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Filtr> query = builder.createQuery(Filtr.class);
        Root root = query.from(Filtr.class);
        filtr = session.createQuery(query).list();
        session.close();

        return filtr;
    }

    public List<Filtr> getStreamLecture() {

        List<Filtr> filtrs = new ArrayList<Filtr>();
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            filtrs =  session.createQuery("Select f from Filtr f " +
                    "INNER JOIN com.spring.dto.Teacher t on f.teacherId = t.id " +
                    "where stream_group_id in (Select s.id from com.spring.dto.Stream s  where name Is NOT NUll) " +
                    "AND NOT lecture_number  = 0 ORDER BY t.priority DESC ", Filtr.class).getResultList();
       } catch (Exception e) {
            e.printStackTrace();
        }
        return filtrs;
   }

    @Override
    public List<Filtr> getPracSubject() {
        List<Filtr> filtrs = new ArrayList<Filtr>();
        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            filtrs =  session.createQuery("Select  (f.labNumber +f.practicNumber ) from com.spring.dto.Filtr f " +
                    "INNER JOIN com.spring.dto.Subject s on  f.subjectId=s.id " +
                    "inner join com.spring.dto.Teacher t on  f.teacherId=t.id " +
                    "where labNumber is NOT null and practicNumber is not null ", Filtr.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtrs;
    }

    @Override
    public List<Filtr> getTeacherBySubject() {
        List<Filtr> filtr = new ArrayList<Filtr>();
        try {
            Session session = sessionFactory.openSession();
            filtr =  session.createQuery(" SELECT f FROM com.spring.dto.Filtr f " +
                    "  INNER join com.spring.dto.Teacher t on f.teacherId = t.id" +
                    "  INNER JOIN com.spring.dto.Subject s on f.subjectId =s.id", Filtr.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtr;
    }

    @Override
    public Integer getNumberOfLectureByFiltr(Filtr f) {
        Session session = sessionFactory.openSession();
        Integer count = (Integer)session.createQuery("SELECT sum(lectureNumber)/15 FROM com.spring.dto.Filtr" +
                " where streamGroupId.id = :stream and subjectId.id = :subject and lectureNumber IS NOT NULL").
                setParameter("stream",f.getStreamGroupId().getId()).
                setParameter("subject",f.getSubjectId().getId()).getSingleResult();

        return count;
    }

    @Override
    public Integer getPracAndLabNumByFiltr(Filtr f) {
        Session session = sessionFactory.openSession();
        Integer count = (Integer)session.createQuery("SELECT (f.labNumber+f.practicNumber)/15 FROM com.spring.dto.Filtr f " +
                "JOIN com.spring.dto.StreamGroup sg ON(f.streamGroupId = sg.id ) " +
                "JOIN com.spring.dto.Group g ON(sg.groupId = g.id) WHERE f.streamGroupId.id=:group and f.subjectId.id=:subject").
                setParameter("group", f.getStreamGroupId().getId()).
                setParameter("subject", f.getSubjectId().getId()).getSingleResult();
        return count;
    }


    @Override
    public List<WeekDay> getAllWeekDay() {
        List<WeekDay> weekDays = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<WeekDay> query = builder.createQuery(WeekDay.class);
        Root root = query.from(WeekDay.class);
        weekDays = session.createQuery(query).list();
        session.close();

        return weekDays;
    }

    @Override
    public List<SubjectType> getDividedSubject() {
        List<SubjectType> subjects = new ArrayList<SubjectType>();
        try {
            Session session = sessionFactory.openSession();
            subjects =  session.createQuery("SELECT r FROM com.spring.dto.SubjectType r \n" +
                    " inner join com.spring.dto.Subject s ON r.subjectId = s.id\n" +
                    " WHERE divide = 0", SubjectType.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public List<Room> getRoomsByNotes() {
        List<Room> rooms = new ArrayList<Room>();
        try {
            Session session = sessionFactory.openSession();
            rooms =  session.createQuery("SELECT r FROM com.spring.dto.Room r  " +
                    "inner join com.spring.dto.RoomNotes n ON r.id = n.roomId", Room.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;

    }

    public List<Room> getRoomsbyNotesAndFreeTime() {
        List<Room> rooms = new ArrayList<Room>();
        try {
            Session session = sessionFactory.openSession();
            rooms =  session.createQuery("SELECT r FROM com.spring.dto.Room r" +
                    "    inner join com.spring.dto.RoomNotes n ON r.id = n.roomId" +
                    "    INNER JOIN com.spring.dto.RoomFreeTime t on r.id = t.roomId", Room.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<DayHours> getAllHour() {
        List<DayHours> hours = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DayHours> query = builder.createQuery(DayHours.class);
        Root root = query.from(DayHours.class);
        hours = session.createQuery(query).list();
        session.close();

        return hours;
    }


    @Override
    public void insertSchedule(Schedule s) {

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(s);
            transaction.commit();
            session.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public void addSchedule(Schedule s) {

        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(s);
            transaction.commit();
            session.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    public List<StreamGroup> getGroupByStreamId(Group g) {
        List<StreamGroup> list = null;
        try {
            Session session = sessionFactory.openSession();
            Query query =  session.createQuery("select s from com.spring.dto.StreamGroup s where s.streamId.id=:id  ",StreamGroup.class);
            query.setParameter("id", g.getId());
            list = (List<StreamGroup>) query.getResultList();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return list;
    }

    @Override
    public List<StreamGroup> getAllStreamGroup() {
        List<StreamGroup> groups = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<StreamGroup> query = builder.createQuery(StreamGroup.class);
        Root root = query.from(StreamGroup.class);
        groups = session.createQuery(query).list();
        session.close();

        return groups;
    }

    @Override
    public List<Schedule> getAllSchedule() {
        List<Schedule> list = null;

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Schedule> query = builder.createQuery(Schedule.class);
        Root root = query.from(Schedule.class);
        list = session.createQuery(query).list();
        session.close();

        return list;
    }

    @Override
    public boolean scheduleAlreadyHas(Teacher teacher, Group group, WeekDay weekDay, DayHours time, Subject subject) {

        List list =null;
        try {
            Session session = sessionFactory.openSession();
            Query query =  session.createQuery( "SELECT 1 FROM schedule WHERE  " +
                    "                (teacher_id=:teacher and week_day_id=:weekDay and day_hours_id=:dayHours)|| " +
                    "                (group_id=:group and week_day_id=:weekDay and day_hours_id=:dayHours)|| " +
                    "                (subject_id=:subject and week_day_id=:weekDay and day_hours_id=:dayHours)");

            query.setParameter("weekDay",weekDay.getId());
            query.setParameter("teacher",teacher.getId());
            query.setParameter("dayHours",time.getId());
            query.setParameter("subject",subject.getId());
            query.setParameter("group",group.getId());


            list =query.getResultList();
            if(list.size()>0){
                return true;
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean scheduleAlreadyHas(Room room, WeekDay weekDay, DayHours time) {
        List list =null;
        try {
            Session session = sessionFactory.openSession();
            Query query =  session.createQuery("SELECT 1 FROM schedule WHERE  " +
                    "                (room_id=:room and week_day_id=:week and day_hours_id=:hour)");
            query.setParameter("room",room.getId());
            query.setParameter("week",weekDay.getId());
            query.setParameter("hour",time.getId());
            list =  query.getResultList();

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        if(list.size()>0){
            return true;
        }
        return false;
    }


    @Override
    public boolean groupAlreadyHasNLectures(WeekDay weekDay, Group group, DayHours time, Room room) {

        Session session = sessionFactory.openSession();
        BigInteger size = (BigInteger)session.createQuery("SELECT 1 FROM com.spring.dto.Schedule s " +
                "inner join com.spring.dto.Room r on s.roomId=r.id " +
                "WHERE  " +
                " (s.roomId=:room and s.weekDayId=:week and s.dayHoursId=:hour and r.roomTypeId=1)").
                setParameter("room", room.getId()).
                setParameter("week",weekDay.getId()).getSingleResult();

        if (size.intValue() == time.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean lectureAfterThisTime(Group group, Subject subject, WeekDay weekDay, DayHours time) {

        List<Schedule> schedules =null;
        try {
            Session session = sessionFactory.openSession();
            Query query =  session.createQuery("SELECT * FROM schedule" +
                    "                WHERE group_id=:group and subject_id=:subject");
            query.setParameter("group", group.getId());
            query.setParameter("subject", subject.getId());
            schedules = (List<Schedule>) query.getResultList();

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean scheduleAlreadyHasRoomByTime(Room room) {

        List list=null;

            Session session = sessionFactory.openSession();
            Query query =  session.createQuery("SELECT r FROM com.spring.dto.Room r " +
                    "                inner join com.spring.dto.Schedule sh   on r.id = sh.roomId " +
                    "                where sh.roomId.id=:room");
            query.setParameter("room",room.getId());

            list =  query.getResultList();

        if(list.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public Long getNumberOfStudentsByFilter(Filtr filtr) {

        Session session = sessionFactory.openSession();
        Long size = (Long) session.createQuery("SELECT sum(g.numberOfStudents) from com.spring.dto.Group g  " +
                "left join com.spring.dto.StreamGroup sg  on g.id=sg.groupId " +
                "left join com.spring.dto.Filtr f   on  sg.id=f.streamGroupId  " +
                "WHERE f.id =:filtrId ").
                setParameter("filtrId", filtr.getId()).getSingleResult();

        return size;
    }

    //SELECT * FROM schedule WHERE (room_id=82 and week_day_id=2 and day_hour_id=1)
    //SELECT 1 FROM schedules WHERE (room_id=:roomId and week_day_id=:weekDayId and lesson_order=:lessonOrder

    //SELECT * FROM rooms where room_type_id!=1 and capacity>10 and  order by capacity

    //select s.group_id from stream_group s where stream_id=1

    //        SELECT t.fio,s.name FROM filtr f
//    INNER join teachers t on f.teacher_id = t.id
//    INNER JOIN subject s on f.subject_id =s.id

    //SELECT name FROM rooms r  inner join roomNotes n ON r.id = n.room_id
//    SELECT name FROM rooms r
//    inner join roomNotes n ON r.id = n.room_id
//    INNER JOIN room_free_time t on r.id = t.room_id


    //select *  from filtr WHERE stream_group_id in(SELECT id from stream_group where group_id = 1 ) and not lecture_number = 0
    //select COUNT(id)  from filtr WHERE stream_group_id in(SELECT id from stream_group where group_id = 1 ) and not lecture_number = 0
}
