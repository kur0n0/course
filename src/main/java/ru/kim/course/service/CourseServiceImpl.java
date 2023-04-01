package ru.kim.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.kim.course.dto.CourseToUpdateDto;
import ru.kim.course.dao.CourseDao;
import ru.kim.course.dto.CourseToCreateDto;
import ru.kim.course.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll() {
        List<Course> list = new ArrayList<>();
        courseDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Course getById(Long courseId) {
        return courseDao.findById(courseId).orElseThrow(() -> new NoSuchElementException(String.format("Курс с id: %s не найден", courseId)));
    }

    @Override
    public void delete(Long courseId) {
        courseDao.deleteById(courseId);
    }

    @Override
    public Long create(CourseToCreateDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        return courseDao.save(course).getCourseId();
    }

    @Override
    public void update(Long courseId, CourseToUpdateDto dto) {
        Course course = courseDao.findById(courseId).orElseThrow(() -> new NoSuchElementException(String.format("Курс с id: %s не найден", courseId)));
        course.setDescription(dto.getDescription());
        course.setName(dto.getName());

        courseDao.save(course);
    }

    @Override
    public List<Course> findAllByPrefix(String prefix) {
        if(prefix.isEmpty()) {
            throw new IllegalArgumentException("Префикс для поиска не должен быть пустым");
        }

        return courseDao.findCourseByNameStartingWith(prefix);
    }
}
