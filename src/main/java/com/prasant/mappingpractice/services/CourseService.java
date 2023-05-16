package com.prasant.mappingpractice.services;

import com.prasant.mappingpractice.models.Course;
import com.prasant.mappingpractice.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class CourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    public String saveCourse(Course course) {
        AtomicBoolean isPresent = new AtomicBoolean(true);
        course.getStudentList().forEach(
                student -> {
                    if (!studentService.isStudentExist(student.getId()))
                        isPresent.set(false);
                }
        );

        if (!isPresent.get()){
            return "Invalid students";
        }

        courseRepository.save(course);
        return "Course saved successfully!";
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public String updateCourseById(String courseId, Course course) {
        boolean isCoursePresent = courseRepository.existsById(courseId);
        if (!isCoursePresent){
            return "Course doesn't exist!";
        }

        AtomicBoolean isPresent = new AtomicBoolean(true);
        course.getStudentList().forEach(
                student -> {
                    if (!studentService.isStudentExist(student.getId()))
                        isPresent.set(false);
                }
        );

        if (!isPresent.get()){
            return "Invalid students";
        }

        courseRepository.save(course);
        return "Course updated successfully";
    }

    public String deleteCourseById(String courseId) {
        boolean isCoursePresent = courseRepository.existsById(courseId);
        if (!isCoursePresent){
            return "Course doesn't exist!";
        }

        courseRepository.deleteById(courseId);
        return "Course deleted successfully!";
    }
}
