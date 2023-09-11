package com.employee.manage.Dto;

import lombok.*;

@Builder
@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String house;
    private String street;
    private String city;
    private Integer zipCode;
}
