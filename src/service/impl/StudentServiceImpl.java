package service.impl;

import entity.Group;
import entity.Student;
import repository.Storage;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public void addMarks(int id, Integer mark, Storage storage) {
        List<Group> groupList = storage.getGroupList();
        if (groupList != null && !groupList.isEmpty()) {
            for (Group gr : groupList) {
                List<Student> studentList = gr.getStudentList();
                if (studentList != null && !studentList.isEmpty()) {
                    for (Student st : studentList) {
                        List<Integer> ball = st.getMarks();
                        if (st.getId() == id) {
                            if (ball != null) {
                                ball.add(mark);
                            } else {
                                st.setMarks(new ArrayList<>());
                                st.getMarks().add(mark);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addStudent(Student student, Storage storage) {
        if (student != null) {
            List<Student> studentList = storage.getStudentList();
            if (studentList != null) {
                studentList.add(student);
            }
            studentList = new ArrayList<>();
            storage.setStudentList(studentList);
            studentList.add(student);
        }
    }

    @Override
    public void removeStudent(int id, Storage storage) {
        List<Student> studentList = storage.getStudentList();
        Student temp;
        if (studentList != null && !studentList.isEmpty()) {
            for (Student st : studentList) {
                if (st.getId() == id) {
                    temp = st;
                    studentList.remove(temp);
                    return;
                }
            }
        }
    }


    @Override
    public void editStudent(int id, String firstName, String lastName, Storage storage) {
        List<Group> groupList = storage.getGroupList();
        if (groupList != null && !groupList.isEmpty()) {
            for (Group gr : groupList) {
                if (gr.getStudentList() != null && !groupList.isEmpty()) {
                    List<Student> studentList = gr.getStudentList();
                    for (Student st : studentList) {
                        if (st.getId() == id) {
                            st.setFirstName(firstName);
                            st.setLastName(lastName);
                        }
                    }
                }
            }
        }
    }
}
