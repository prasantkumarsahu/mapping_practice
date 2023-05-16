package com.prasant.mappingpractice.repositories;

import com.prasant.mappingpractice.models.Course;
import org.springframework.data.repository.ListCrudRepository;

public interface ICourseRepository extends ListCrudRepository<Course, String> {
}
