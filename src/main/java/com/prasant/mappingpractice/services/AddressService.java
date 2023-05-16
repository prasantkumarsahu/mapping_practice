package com.prasant.mappingpractice.services;

import com.prasant.mappingpractice.models.Address;
import com.prasant.mappingpractice.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    public String saveAddress(Address address) {
        addressRepository.save(address);
        return "Address is saved!";
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public String updateAddressById(Long addressId, Address address) {
        boolean isPresent = addressRepository.existsById(addressId);
        if (!isPresent){
            return "Address is not present!";
        }

        address.setId(addressId);
        addressRepository.save(address);
        return "Address updated successfully!";
    }

    public String deleteAddressById(Long addressId) {
        boolean isPresent = addressRepository.existsById(addressId);
        if (!isPresent){
            return "Address is not present!";
        }

        addressRepository.deleteById(addressId);
        return "Address deleted successfully!";
    }
}
