package com.employee.manage.mapper;

import com.employee.manage.Dto.AddressDto;
import com.employee.manage.Model.Address;
import com.employee.manage.Model.response.CreateEmployeeResponse;
import com.employee.manage.Model.response.UpdateEmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toEntity(CreateEmployeeResponse createEmployeeResponse) {
        Address address = new Address();
        address.setName(createEmployeeResponse.getAddressName());
        address.setStreet(createEmployeeResponse.getAddressStreet());
        address.setCity(createEmployeeResponse.getAddressCity());
        address.setZipCode(Integer.valueOf(createEmployeeResponse.getAddressZipCode()));
        return address;
    }

    public Address toEntity(UpdateEmployeeResponse updateEmployeeResponse) {
        Address address = new Address();
        address.setId(updateEmployeeResponse.getAddressId());
        address.setName(updateEmployeeResponse.getAddressName());
        address.setStreet(updateEmployeeResponse.getAddressStreet());
        address.setCity(updateEmployeeResponse.getAddressCity());
        address.setZipCode(Integer.valueOf(updateEmployeeResponse.getAddressZipCode()));
        return address;
    }

    public AddressDto fromEntity(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .house(address.getName())
                .street(address.getStreet())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .build();
    }
}
