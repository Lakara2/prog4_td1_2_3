package com.employee.manage.Service;

import com.employee.manage.Model.Address;
import com.employee.manage.Repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;

    public Address update(Address address) {
        return addressRepository.save(address);
    }
}
