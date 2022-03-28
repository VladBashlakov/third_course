package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;


import java.util.List;


@Service
public class StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
        logger.info("createStudent completed");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("findStudent completed");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("editStudent completed");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("deleteStudent completed");
        studentRepository.deleteById(id);
    }

    public List<Student> sortStudent(int age) {
        logger.info("sortStudent completed");
        return studentRepository.findByAge(age);
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("findByAgeBetween completed");
        return studentRepository.findByAgeBetween(min, max);
    }

    public List<Student> findAll() {
        logger.info("findAll completed");
        return studentRepository.getCountOfAll();
    }

    public int getAverageAge() {
        logger.info("getAverageAge completed");
        return studentRepository.getAverageAge();
    }

    public List<Student> getLastFiveStudent() {
        logger.info("getLastFiveStudent completed");
        return studentRepository.getFiveLastStudents();
    }
}
