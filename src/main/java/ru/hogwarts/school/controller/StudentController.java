package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/getAllStudentsByStreams")
    public void getAllStudents() {
        studentService.getAllStudentsByStreams();
    }

    @GetMapping("/getAllStudentsBySynchroStreams")
    public void getAllStudentsBySynchroStreams() {
        studentService.getAllStudentsBySynchroStreams();
    }

    @GetMapping("/getAllStudentsTest")
    public void getAllStudentsTest() {
        studentService.getAllStudentsTest();
    }


    @GetMapping("/AgeAVG")
    public int getAVGAgeOfStudents() {
        return studentService.getAVGAgeOfStudents();
    }

    @GetMapping("/filterByLetterA")
    public List<String> getAllStudentNamesAfterFilterByA() {
        return studentService.getAllStudentNamesAfterFilterByA();
    }

    @GetMapping("/id")
    public Student getStudentInfo(@RequestParam long id) {
        return studentService.findStudent(id);
    }

    @GetMapping("{sortAge}")
    public List<Student> sortStudent(@PathVariable int sortAge) {
        return studentService.sortStudent(sortAge);
    }

    @GetMapping
    public List<Student> findByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeBetween(min, max);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;
}
