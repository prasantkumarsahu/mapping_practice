package com.prasant.mappingpractice.repositories;

import com.prasant.mappingpractice.models.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface IAddressRepository extends ListCrudRepository<Address, Long> {
}
