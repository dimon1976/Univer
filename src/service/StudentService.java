package service;

import entity.Student;
import repository.Storage;

public interface StudentService {
    void addMarks(int id, Integer mark, Storage storage);

    void addStudent(Student student, Storage storage);

    void removeStudent(int id, Storage storage);

    void editStudent(int id, String firstName,String lastName, Storage storage);

}
