package com.employee.manage.mapper;

import com.employee.manage.Dto.CinDto;
import com.employee.manage.Model.Cin;
import com.employee.manage.Model.response.CreateEmployeeResponse;
import com.employee.manage.Model.response.UpdateEmployeeResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CinMapper {
    public Cin toEntity(CreateEmployeeResponse createCinDto) {
        Cin cin = new Cin();
        cin.setCinNumber(createCinDto.getCinNumber());
        cin.setCinDeliveryDate(LocalDate.parse(createCinDto.getCinDeliveryDate()));
        cin.setCinDeliveryPlace(createCinDto.getCinDeliveryPlace());
        return cin;
    }

    public Cin toEntity(UpdateEmployeeResponse updateEmployeeResponse) {
        Cin cin = new Cin();
        cin.setId(updateEmployeeResponse.getCinId());
        cin.setCinNumber(updateEmployeeResponse.getCinNumber());
        cin.setCinDeliveryDate(LocalDate.parse(updateEmployeeResponse.getCinDeliveryDate()));
        cin.setCinDeliveryPlace(updateEmployeeResponse.getCinDeliveryPlace());
        return cin;
    }

    public CinDto fromEntity(Cin cin) {
        return CinDto.builder()
                .id(cin.getId())
                .cinNumber(cin.getCinNumber())
                .cinDeliveryDate(cin.getCinDeliveryDate())
                .cinDeliveryPlace(cin.getCinDeliveryPlace())
                .build();
    }
}
