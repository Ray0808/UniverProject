package com.spring.controller;

import com.spring.beans.UserBean;
import com.spring.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private static final int LEC = 1;
    private static final int PRAC = 2;
    private static final int LAB = 5;

    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/")
    public ModelAndView ndex(HttpSession session) {
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index")
    public ModelAndView index(HttpSession session) {

        return new ModelAndView("index");

    }

    @RequestMapping(value = {"/schedule"}, method = RequestMethod.GET)
    public ModelAndView listAdmins() {
        List<Schedule> list = userBean.getAllSchedule();
        List<Group> groups = userBean.getAllGroups();
        List<WeekDay> weekDays = userBean.getAllWeekDay();
        List<Room> roomList = userBean.getAllRooms();

        ModelAndView view = new ModelAndView("schedule");

        view.addObject("schedule", list);
        view.addObject("groups", groups);
        view.addObject("week", weekDays);
        view.addObject("room", roomList);

        return view;

    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ModelAndView listRoom() {
        // List<Room> room = userBean.getAllRooms();
        // List<Room> rooms = userBean.getRoomsByNotes();
        // List<Room> rooms1 = userBean.getRoomsbyNotesAndFreeTime();

        //List<StreamGroup> streamGroups =
        List<Group> groups = userBean.getAllGroups();
        for (int i = 0; i < groups.size(); i++) {
            userBean.getGroupByStreamId(groups.get(1));
        }
        ModelAndView view = new ModelAndView("room");
        // view.addObject("list", room);
        // view.addObject("note", rooms);
        //view.addObject("st", streamGroups);
        return view;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public ModelAndView generate(HttpServletRequest request,
                                 @RequestParam(name = "generate") String generate) {

        List<Filtr> filtrList = userBean.getStreamLecture();
        List<Filtr> labAndPrac = userBean.getPracSubject();
        List<Subject> subject = userBean.getAllSubjects();
        //List<Room> roomList = userBean.getAllRooms();
        List<Room> lectureRoom = userBean.getLectureRoom();

        //TODO cheack methods to   insert into schedule

        Schedule schedule = new Schedule();
        for (Filtr filrt : filtrList) {
           // for (Subject s : subject) {

                   List<Room> practiceRoom = userBean.getLabAndPracRoom(filrt);

                // List<StreamGroup> streamGroups = userBean.getAllStreamGroup();
                //for(StreamGroup s : streamGroups ) {
                // streamGroups = userBean.getGroupByStreamId(s.getGroupId());
                //   for (StreamGroup streamGroup : streamGroups) {
                //for(Room lecroom :  lectureRoom) {
                //   for(Room pracroom : practiceRoom) {
                //schedule.setGroupId(filrt.getStreamGroupId());
                schedule.setSubjectId(filrt.getSubjectId());
                schedule.setTeacherId(filrt.getTeacherId());

                  //schedule.setRoomId(lecroom);

                userBean.insertSchedule(schedule);

                //}
             //    }
                // }
           // }
        }

        return new ModelAndView("schedule");
    }


//        List<Filtr> filtrs = userBean.getAllFiltr();
//        ModelAndView view = new ModelAndView("final");
//        for (Filtr f :  filtrs) {
//
//            Filtr filtr = new Filtr();
//            filtr.setStreamGroupId(f.getStreamGroupId());
//            filtr.setSubjectId(f.getSubjectId());
//
//            Integer numb = userBean.getPracAndLabNumByFiltr(filtr);
//
//            System.out.println("sdasdasdasdasd "+numb);
//            view.addObject("list", numb);
//        }
//        return view;


    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ModelAndView addRoom(HttpServletRequest request,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "capacity") String capacity,
                                @RequestParam(name = "has_computer)id") String hasComputer) {

        //    RoomType roomTypeId = (RoomType) userBean.getAllRoomTypes();
        //Room r = new Room(name,Integer.parseInt(capacity),roomTypeId,Integer.parseInt(hasComputer));

        //userBean.addRoom(r);

        return new ModelAndView("room");
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView listTeacher() {
        List<Filtr> filtrs = userBean.getTeacherBySubject();
        ModelAndView view = new ModelAndView("teacher");
        view.addObject("sbj", filtrs);
        return view;
    }

    @RequestMapping(value = "/sc", method = RequestMethod.GET)
    public ModelAndView listsc() {
        //  List<Schedule> list = userBean.getAllSchedule();
        List<Group> groups = userBean.getAllGroups();
        List<WeekDay> weekDays = userBean.getAllWeekDay();
        ModelAndView view = new ModelAndView("sc");
        //  view.addObject("list",list);
        view.addObject("group", groups);
        view.addObject("week", weekDays);
        return view;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public ModelAndView addTeacher(HttpServletRequest request,
                                   @RequestParam(name = "fio") String fio,
                                   @RequestParam(name = "priority") String priority) {

        // Teacher t = new Teacher(fio,priority);
        //userBean.addTeacher(t);

        return new ModelAndView("teacher");
    }

    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public ModelAndView listSubject() {
        //List<Subject> subjects = userBean.getAllSubjects();
        List<SubjectType> divSubjects = userBean.getDividedSubject();
        ModelAndView view = new ModelAndView("subject");
        //  view.addObject("sub", subjects);
        view.addObject("div", divSubjects);
        return view;
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST)
    public ModelAndView addSubject(HttpServletRequest request,
                                   @RequestParam(name = "name") String name,
                                   @RequestParam(name = "needComputer") String needComputer,
                                   @RequestParam(name = "semester") String semester) {

        //Subject t = new Subject(name,Integer.parseInt(needComputer),Integer.parseInt(semester));

        // userBean.addSubject(t);

        return new ModelAndView("subject");
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public ModelAndView listWeekDay() {

        List<Filtr> filtrs = userBean.getPracSubject();
        ModelAndView view = new ModelAndView("final");

        view.addObject("list", filtrs);

        return view;
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ModelAndView listGroup() {

        List<Group> groups = userBean.getAllGroups();
        ModelAndView view = new ModelAndView("group");
        view.addObject("list", groups);
        return view;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public ModelAndView addGroup(HttpServletRequest request,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "num") String num) {

        // Group t = new Group(name,Integer.parseInt(num));

        //userBean.addGroup(t);

        return new ModelAndView("group");
    }

    @RequestMapping(value = "/filtr", method = RequestMethod.GET)
    public ModelAndView listStreamGroup() {

        List<Filtr> filtr = userBean.getStreamLecture();
        ModelAndView view = new ModelAndView("filtr");
        view.addObject("list", filtr);
        return view;
    }

    private void addLectureAndPractice(Filtr filtr, Group group, List<Group> groups) {
        if (group == null) {
            for (int i = 0; i < filtr.getLectureNumber() / 15; i++) {
                if (chooseDayAndTime(filtr, null, groups)) {
                }
            }
        } else {
            for (int i = 0; i < filtr.getPracticNumber() / groups.size() / 15; i++) {
                if (chooseDayAndTime(filtr, null, groups)) {
                }
            }
        }
    }

    private boolean chooseDayAndTime(Filtr filtr, Group group, List<Group> groups) {
        for (Room r : userBean.getAllRooms()) {
            for (WeekDay weekDay : userBean.getAllWeekDay()) {
                for (DayHours dayHours : userBean.getAllHour()) {
                    if (group == null) {
                        Long size = userBean.getNumberOfStudentsByFilter(filtr);
                        if (added(groups, filtr.getSubjectId(), filtr.getTeacherId(), weekDay, dayHours, r, LEC)) {
                            return true;
                        }
                    } else {
                        groups = new ArrayList<>();
                        groups.add(group);
                        if (added(groups, filtr.getSubjectId(), filtr.getTeacherId(), weekDay, dayHours, r, PRAC) ||
                                added(groups, filtr.getSubjectId(), filtr.getTeacherId(), weekDay, dayHours, r, LAB)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    // @RequestMapping(value = "/sc", method = RequestMethod.POST)
    private boolean added(List<Group> groups, Subject subject, Teacher teacher, WeekDay
            weekDay, DayHours time, Room room, int type) {

        ModelAndView view = new ModelAndView("sc");
        List<Room> roomList = userBean.getAllRooms();
        for (Group group : groups) {
            for (Room r : roomList) {
                if (userBean.scheduleAlreadyHas(teacher, group, weekDay, time, subject)) {
                    break;
                }
                if (r.getRoomTypeId().getId() == LEC && userBean.groupAlreadyHasNLectures(weekDay, group, time, room)) {
                    break;
                }
                if (r.getRoomTypeId().getId() == PRAC || r.getRoomTypeId().getId() == LAB && userBean.lectureAfterThisTime(group, subject, weekDay, time)) {
                    break;
                }
            }
        }

        Room rooms = getRoom(weekDay, time);
        for (Group group : groups) {
            Schedule s = new Schedule();
            s.setGroupId(group);
            s.setRoomId(room);
            s.setSubjectId(subject);
            s.setTeacherId(teacher);
            s.setWeekDayId(weekDay);
            s.setDayHoursId(time);

            userBean.addSchedule(s);
        }
        return true;
    }

    private Room getRoom(WeekDay weekDay, DayHours time) {
        List<Room> roomList = userBean.getAllRooms();
        for (Room r : roomList) {
            if (r.getRoomTypeId().getId() == LEC) {
                List<Room> lectureRooms = userBean.getLectureRoom();

                for (Room room : lectureRooms) {
                    if (!userBean.scheduleAlreadyHas(room, weekDay, time)) {
                        return room;
                    }
                }
                return lectureRooms.get(0);
            } else {
                List<Filtr> filtrList = userBean.getAllFiltr();
                for (Filtr f : filtrList) {
                    List<Room> practiceRooms = userBean.getLabAndPracRoom(f);
                    for (Room room : practiceRooms) {
                        if (!userBean.scheduleAlreadyHas(room, weekDay, time)) {

                        }
                    }
                }
            }
        }
        return new Room();
    }
    //SELECT * FROM subject_type  inner join  Subject s ON subject_type.subject_id = s.id

    //SELECT name FROM rooms r  inner join roomNotes n ON r.id = n.room_id

//    SELECT name FROM rooms r
//    inner join roomNotes n ON r.id = n.room_id
//    INNER JOIN room_free_time t on r.id = t.room_id
}
