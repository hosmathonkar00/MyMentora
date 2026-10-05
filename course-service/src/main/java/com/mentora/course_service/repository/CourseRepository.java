package com.mentora.course_service.repository;

import com.mentora.course_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
