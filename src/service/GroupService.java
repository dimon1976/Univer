package service;

import repository.Storage;

public interface GroupService {
    void addStudentGroup(int id, String nameGroup, Storage storage);

    void removeStudentByName(String name, Storage storage);

    void removeStudentById(int id, Storage storage);

    void printById(int id, Storage storage);

    void printByFirstName(String firstName, Storage storage);

    void sumMarks(Storage storage);

}
