package com.prasant.mappingpractice.services;

import com.prasant.mappingpractice.models.Laptop;
import com.prasant.mappingpractice.models.Student;
import com.prasant.mappingpractice.repositories.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private ILaptopRepository laptopRepository;

    @Autowired
    private StudentService studentService;

    public String saveLaptop(Laptop laptop) {
        Student student = studentService.getStudentById(laptop.getStudent().getId());
        if (student == null){
            return "Student doesn't exist!";
        }

        laptop.setStudent(student);
        laptopRepository.save(laptop);
        return "Laptop is added!";
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public String updateLaptopById(String lapId, Laptop laptop) {
        boolean isLaptopPresent = laptopRepository.existsById(lapId);
        if (!isLaptopPresent){
            return "Laptop is not exist!";
        }

        boolean isStudentPresent = studentService.isStudentExist(laptop.getStudent().getId());
        if (!isStudentPresent){
            return "Student doesn't exist!";
        }

        laptop.setId(lapId);
        laptopRepository.save(laptop);
        return "Laptop updated successfully!";
    }

    public String deleteLaptopById(String laptopId) {
        boolean isPresent = laptopRepository.existsById(laptopId);
        if (!isPresent){
            return "Laptop is not exist!";
        }

        laptopRepository.deleteById(laptopId);
        return "Laptop deleted successfully!";
    }
}
