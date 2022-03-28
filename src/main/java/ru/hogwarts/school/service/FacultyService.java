package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import ru.hogwarts.school.repository.FacultyRepository;


import java.util.List;


@Service
public class FacultyService {
   private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public List<Faculty> findFacultyByColorIgnoreCase(String color) {
        logger.info("findFacultyByColorIgnoreCase completed");
        return facultyRepository.findFacultyByColorIgnoreCase(color);
    }

    public List<Faculty> findFacultyByNameContainsIgnoreCase(String name) {
        logger.info("findFacultyByNameContainsIgnoreCase completed");
        return facultyRepository.findFacultyByNameContainsIgnoreCase(name);
    }


    public Faculty createFaculty(Faculty faculty) {
        logger.info("createFaculty completed");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("findFaculty completed");
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("editFaculty completed");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("deleteFaculty completed");
        facultyRepository.deleteById(id);
    }

    public List<Faculty> sortFaculty(String color) {
        logger.info("sortFaculty completed");
        return facultyRepository.findByColor(color);
    }

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

}



