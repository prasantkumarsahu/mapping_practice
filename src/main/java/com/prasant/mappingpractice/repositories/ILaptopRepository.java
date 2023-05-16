package com.prasant.mappingpractice.repositories;
import com.prasant.mappingpractice.models.Laptop;
import org.springframework.data.repository.ListCrudRepository;

public interface ILaptopRepository extends ListCrudRepository<Laptop, String> {
}
