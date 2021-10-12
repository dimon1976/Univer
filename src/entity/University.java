package entity;

import java.util.List;

public class University {
    private String name;
    private List<Group> groupList;

    public University() {
    }

    public University(String name, List<Group> groupList) {
        this.name = name;
        this.groupList = groupList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "В Университете - '" +
                name + '\'' + " " +
                groupList +
                '}';
    }
}
