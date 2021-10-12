package entity;

import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private List<Integer> marks;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, List<Integer> marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", оценки=" + marks +
                '}';
    }
}
