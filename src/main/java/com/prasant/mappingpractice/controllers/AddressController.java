package com.prasant.mappingpractice.controllers;

import com.prasant.mappingpractice.models.Address;
import com.prasant.mappingpractice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping()
    public String addAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping()
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @PutMapping("{addressId}")
    public String updateAddress(@PathVariable Long addressId, @RequestBody Address address){
        return addressService.updateAddressById(addressId, address);
    }

    @DeleteMapping("{addressId}")
    public String deleteAddress(@PathVariable Long addressId){
        return addressService.deleteAddressById(addressId);
    }
}
