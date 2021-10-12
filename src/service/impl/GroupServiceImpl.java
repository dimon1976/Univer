package service.impl;

import entity.Group;
import entity.Student;
import repository.Storage;
import service.GroupService;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService {
    @Override
    public void addStudentGroup(int id, String nameGroup, Storage storage) {
        //»щем студента в storage по id
        List<Student> studentList = storage.getStudentList();
        List<Group> groupList = storage.getGroupList();
        Student st = null;
        if (studentList != null && !studentList.isEmpty()) {
            for (Student student : studentList) {
                if (student.getId() == id) {
                    st = student;
                }
            }
        }
        // »щем группу по имени и добавл€ем студента
        if (groupList != null && !groupList.isEmpty())
            for (Group gr : groupList) {
                if (gr.getName().equals(nameGroup)) {
                    if (gr.getStudentList() == null) {
                        gr.setStudentList(new ArrayList<>());
                    }
                    gr.getStudentList().add(st);
                }
            }
    }


    @Override
    public void removeStudentByName(String name, Storage storage) {
        if (name != null && !name.isEmpty()) {
            List<Group> groupList = storage.getGroupList();
            if (groupList != null && !groupList.isEmpty()) {
                for (Group group : groupList) {
                    List<Student> studentList = group.getStudentList();
                    if (studentList != null && !studentList.isEmpty()) {
                        for (Student st : studentList) {
                            if (name.equals(st.getFirstName())) {
                                studentList.remove(st);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void removeStudentById(int id, Storage storage) {
        if (id > 0) {
            List<Group> groupList = storage.getGroupList();
            if (groupList != null && !groupList.isEmpty()) {
                for (Group group : groupList) {
                    List<Student> studentList = group.getStudentList();
                    if (studentList != null && !studentList.isEmpty()) {
                        for (Student st : studentList) {
                            if (id == (st.getId())) {
                                studentList.remove(st);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void printById(int id, Storage storage) {
        if (id > 0) {
            List<Group> groupList = storage.getGroupList();
            if (groupList != null && !groupList.isEmpty()) {
                for (Group group : groupList) {
                    List<Student> studentList = group.getStudentList();
                    if (studentList != null && !studentList.isEmpty()) {
                        for (Student st : studentList) {
                            if (id == (st.getId())) {
                                System.out.println(st);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void printByFirstName(String firstName, Storage storage) {
        if (firstName != null && !firstName.isEmpty()) {
            List<Group> groupList = storage.getGroupList();
            if (groupList != null && !groupList.isEmpty()) {
                for (Group group : groupList) {
                    List<Student> studentList = group.getStudentList();
                    if (studentList != null && !studentList.isEmpty()) {
                        for (Student st : studentList) {
                            if (firstName.equals(st.getFirstName())) {
                                System.out.println(st);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void sumMarks(Storage storage) {
        Integer sum = 0;
        double count = 0;
        List<Group> groupList = storage.getGroupList();
        if (groupList != null && !groupList.isEmpty()) {
            for (Group group : groupList) {
                List<Student> studentList = group.getStudentList();
                if (studentList != null && !studentList.isEmpty()) {
                    for (Student st : studentList) {
                        List<Integer> marks = st.getMarks();
                        if (marks != null && !marks.isEmpty()) {
                            count++;
                            for (Integer in : marks) {
                                sum += in;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("—редний балл всех студентов - " + sum / count);
    }
}
