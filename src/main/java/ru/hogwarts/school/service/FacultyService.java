package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    public HashMap<Long, Faculty> sortFaculty(String color) {
        HashMap<Long, Faculty> facultyCopy = new HashMap<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor().equals(color)) {
                facultyCopy.put(faculty.getId(), faculty);
            }
        }
        return facultyCopy;
    }


}
