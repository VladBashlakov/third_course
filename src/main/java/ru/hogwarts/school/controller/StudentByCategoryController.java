package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class StudentByCategoryController {
    public final StudentService studentService;

    public StudentByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/count-all")
    public Integer getCountOfAllStudents() {
        return studentService.getCountOfAllStudents();
    }

    @GetMapping("/avg-age")
    public int getAvgAge() {
        return studentService.getAverageAge();
    }
    @GetMapping("/get-last-5-students")
    public List<Student> getFiveLastStudents() {
        return studentService.getLastFiveStudent();
    }
}
