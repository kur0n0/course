package ru.kim.course.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kim.course.model.Course;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<Course, Long> {

    List<Course> findCourseByNameStartingWith(String prefix);
}
