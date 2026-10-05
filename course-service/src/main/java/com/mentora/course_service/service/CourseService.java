package com.mentora.course_service.service;

import com.mentora.course_service.entity.Course;
import com.mentora.course_service.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {

        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {

        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course coursedetails) {

        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(coursedetails.getName());
            course.setDescription(coursedetails.getDescription());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {

        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
        }
    }
}