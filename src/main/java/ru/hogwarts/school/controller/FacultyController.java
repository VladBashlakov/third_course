package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @GetMapping("/findTheLongestNameOfFaculty")
        public String findTheLongestNameOfFaculty() {
            return facultyService.findTheLongestNameOfFaculty();
    }

    @GetMapping("/findAllByName")
    public List<Faculty> findAllByName(@RequestParam String name) {
        return facultyService.findFacultyByNameContainsIgnoreCase(name);
    }

    @GetMapping("/findAllByColor")
    public List<Faculty> findAllByColor(@RequestParam String color) {
        return facultyService.findFacultyByColorIgnoreCase(color);
    }

    @GetMapping("/id")
    public Faculty getFacultyInfo(@RequestParam long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{sortColor}")
    public List<Faculty> sortFaculty(@PathVariable String sortColor) {
        return facultyService.sortFaculty(sortColor);
    }


    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
}
