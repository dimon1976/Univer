package entity;

import java.util.List;

public class Group {
    private int id;
    private List<Student> studentList;
    private String name;

    public Group() {
    }

    public Group(int id, List<Student> studentList, String name) {
        this.id = id;
        this.studentList = studentList;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Группа " +
                name + '\'' +
                ", id=" + id +
                ", список студентов " + studentList +

                '}';
    }
}
