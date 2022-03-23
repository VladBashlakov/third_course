package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import ru.hogwarts.school.repository.FacultyRepository;


import java.util.List;


@Service
public class FacultyService {
    public List<Faculty> findFacultyByColorIgnoreCase(String color) {
        return facultyRepository.findFacultyByColorIgnoreCase(color);
    }

    public List<Faculty> findFacultyByNameContainsIgnoreCase(String name) {
        return facultyRepository.findFacultyByNameContainsIgnoreCase(name);
    }


    public Faculty createFaculty(Faculty faculty) {

        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {

        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {

        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {

        facultyRepository.deleteById(id);
    }

    public List<Faculty> sortFaculty(String color) {

        return facultyRepository.findByColor(color);
    }

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
}



