package ru.kim.course.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kim.course.dto.CourseToCreateDto;
import ru.kim.course.dto.CourseToUpdateDto;
import ru.kim.course.model.Course;
import ru.kim.course.service.CourseService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping(value = "/{courseId}")
    public Course getById(@PathVariable Long courseId) {
        return courseService.getById(courseId);
    }

    @PostMapping
    public Long create(@RequestBody @Valid CourseToCreateDto course) {
        return courseService.create(course);
    }

    @DeleteMapping(value = "/{courseId}")
    public void delete(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }

    @PutMapping(value = "/{courseId}")
    public void update(@PathVariable Long courseId, @RequestBody CourseToUpdateDto course) {
        courseService.update(courseId, course);
    }

    @GetMapping(value = "/search")
    public List<Course> findAllCourseByPrefix(@RequestParam String prefix) {
        return courseService.findAllByPrefix(prefix);
    }
}
