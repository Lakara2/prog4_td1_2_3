package com.employee.manage.Model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
public class IndustryAddress {
    private String name;
    private String street;
    private String city;
    private String zipCode;

    public IndustryAddress(String name, String street, String city, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
