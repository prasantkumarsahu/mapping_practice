package com.prasant.mappingpractice.repositories;
import com.prasant.mappingpractice.models.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface IStudentRepository extends ListCrudRepository<Student, String> {
}
