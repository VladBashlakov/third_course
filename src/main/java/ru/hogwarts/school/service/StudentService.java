package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    public void getAllStudentsBySynchroStreams() {

        synchronized (StudentRepository.class) {
            System.out.println(studentRepository.findById(0L));
            System.out.println(studentRepository.findById(1L));
        }

        new Thread(() -> {
            synchronized (StudentRepository.class) {
                System.out.println(studentRepository.findById(2L));
                System.out.println(studentRepository.findById(3L));
            }
        }).start();

        new Thread(() -> {
            synchronized (StudentRepository.class) {
                System.out.println(studentRepository.findById(3L));
                System.out.println(studentRepository.findById(4L));
            }
        }).start();

    }


    public void getAllStudentsByStreams() {

        System.out.println(studentRepository.findById(0L));
        System.out.println(studentRepository.findById(1L));

        new Thread(() -> {
            System.out.println(studentRepository.findById(1L));
            System.out.println(studentRepository.findById(2L));
        }).start();

        new Thread(() -> {
            System.out.println(studentRepository.findById(4L));
            System.out.println(studentRepository.findById(5L));
        }).start();

    }

    public void getAllStudentsTest() {
        for (int i = 0; i < findAll().size(); i++) {
            System.out.println(findAll().get(i));
        }
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

    public List<String> getAllStudentNamesAfterFilterByA() {
        return studentRepository.findAll().stream().parallel()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(it -> it.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    public int getAVGAgeOfStudents() {
        return (int) studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
