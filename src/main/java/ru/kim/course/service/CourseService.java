package ru.kim.course.service;

import ru.kim.course.dto.CourseToUpdateDto;
import ru.kim.course.dto.CourseToCreateDto;
import ru.kim.course.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Long create(CourseToCreateDto dto);

    Course getById(Long courseId);

    void delete(Long courseId);

    void update(Long courseId, CourseToUpdateDto dto);

    List<Course> findAllByPrefix(String prefix);
}
