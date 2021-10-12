package service;

import entity.Group;
import entity.University;
import repository.Storage;

import java.util.List;

public interface UniversityService {
    void addUniversity(University university, Storage storage);

    University removeUniversity(University university, Storage storage);

    List<University> findAllUniversities(Storage storage);

    University findByName(String name, Storage storage);

    void addGroupToUniversity(Group group, String name, Storage storage);

    void removeGroup(int id, String name, Storage storage);
}
