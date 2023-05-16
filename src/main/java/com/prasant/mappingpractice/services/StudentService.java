package com.prasant.mappingpractice.services;

import com.prasant.mappingpractice.models.Student;
import com.prasant.mappingpractice.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;

    public String saveStudent(Student student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String updateStudent(String id, Student updatedStudent) {
        boolean isPresent = studentRepository.existsById(id);
        if (!isPresent){
            return "Student doesn't exist!";
        }

        updatedStudent.setId(id);
        studentRepository.save(updatedStudent);
        return "Student updated successfully!";
    }

    public String deleteStudentById(String id) {
        boolean isPresent = studentRepository.existsById(id);
        if (!isPresent){
            return "Student doesn't exist!";
        }

        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }

    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public boolean isStudentExist(String id) {
        return studentRepository.existsById(id);
    }
}
