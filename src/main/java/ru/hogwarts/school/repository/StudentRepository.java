package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);

    List<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer getCountOfAll();

    @Query(value = "SELECT AVG(age) from student", nativeQuery = true)
    int getAverageAge();

    @Query(value = "SELECT*FROM student ORDER BY id DESC LIMIT 5",nativeQuery = true)
    List<Student> getFiveLastStudents();

}
