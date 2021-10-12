package service.impl;

import entity.Group;
import entity.University;
import repository.Storage;
import service.UniversityService;

import java.util.ArrayList;
import java.util.List;

public class UniversityGroupImpl implements UniversityService {

    @Override
    public void addUniversity(University university, Storage storage) {
        if (storage.getUniversityList() == null) {
            storage.setUniversityList(new ArrayList<>());
            List<University> universityList = storage.getUniversityList();
            universityList.add(university);
        }
    }

    @Override
    public University removeUniversity(University university, Storage storage) {
        if (university != null) {
            List<University> universityList = storage.getUniversityList();
            if (universityList != null && !universityList.isEmpty()) {
                for (University univer : universityList) {
                    if (university.getName().equalsIgnoreCase(univer.getName())) {
                        universityList.remove(university);
                        System.out.println("Delete");
                        return null;
                    }
                }
            } else {
                System.out.println("Список университетов пуст");
            }
        } else {
            System.out.println("Название университета пустое");
        }
        return null;
    }

    @Override
    public List<University> findAllUniversities(Storage storage) {
        List<University> universityList = storage.getUniversityList();
        if (universityList != null && !universityList.isEmpty()) {
            return universityList;
        }
        System.out.println("Список университетов пуст");
        return null;
    }

    @Override
    public University findByName(String name, Storage storage) {
        if (name != null && !name.isEmpty()) {
            List<University> universityList = storage.getUniversityList();
            if (universityList != null && !universityList.isEmpty()) {
                for (University university : universityList) {
                    if (university.getName().equals(name)) {
                        return university;
                    }
                }
            } else {
                System.out.println("Пустой список");
            }
        } else {
            System.out.println("Неправильное имя");
        }
        return null;
    }

    @Override
    public void addGroupToUniversity(Group group, String name, Storage storage) {
        if (name != null && !name.isEmpty()) {
            if (group != null) {
                List<University> universityList = storage.getUniversityList();
                if (universityList != null && !universityList.isEmpty()) {
                    for (University universityIt : universityList) {
                        if (universityIt.getName().equals(name)) {
                            List<Group> groupList = universityIt.getGroupList();
                            if (groupList == null) {
                                groupList = new ArrayList<>();
                                universityIt.setGroupList(groupList);
                                storage.setGroupList(groupList);
                            }
                            groupList.add(group);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void removeGroup(int id, String name, Storage storage) {
        if (id > 0) {
            if (name != null && !name.isEmpty()) {
                List<University> universityList = storage.getUniversityList();
                if (universityList != null && !universityList.isEmpty()) {
                    for (University university : universityList) {
                        if (university.getName().equals(name)) {
                            List<Group> groupList = university.getGroupList();
                            if (groupList == null || groupList.isEmpty()) {
                                return;
                            }
                            for (Group group : groupList) {
                                if (group.getId() == id) {
                                    university.getGroupList().remove(group);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
