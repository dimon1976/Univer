package controller;

import entity.Group;
import entity.Student;
import entity.University;
import repository.Storage;
import service.GroupService;
import service.StudentService;
import service.UniversityService;
import service.impl.GroupServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.UniversityGroupImpl;

import java.util.Arrays;

public class Menu {
    public static void menu() {
        Storage storage = new Storage();
        StudentService studentService = new StudentServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        UniversityService universityService = new UniversityGroupImpl();

        University university = new University(); /* создаем университет */
        university.setName("Harvard");
        universityService.addUniversity(university, storage);

        Group group1 = new Group(); /* создаем группу */
        group1.setName("Math");
        group1.setId(71);
        universityService.addGroupToUniversity(group1, "Harvard", storage);

        Group group2 = new Group(); /* создаем группу */
        group2.setName("Sapr");
        group2.setId(33);
        universityService.addGroupToUniversity(group2, "Harvard", storage);

        Group group3 = new Group(); /* создаем группу */
        group3.setName("Test");
        group3.setId(156);
        universityService.addGroupToUniversity(group3, "Harvard", storage);

        Student student = new Student();  /* создаем студента */
        student.setId(1);
        student.setFirstName("Dzmitry");
        student.setLastName("Halaidzin");
        student.setMarks(Arrays.asList(9, 4));
        studentService.addStudent(student, storage);
        groupService.addStudentGroup(1, "Math", storage);

        Student student2 = new Student();  /* создаем студента */
        student2.setId(2);
        student2.setFirstName("Иван");
        student2.setLastName("Иванов");
        studentService.addStudent(student2, storage);
        groupService.addStudentGroup(2, "Math", storage);
        studentService.editStudent(2, "First", "Last", storage);
        studentService.addMarks(2,5,storage);
        groupService.sumMarks(storage);
        System.out.println(university);
    }
}

