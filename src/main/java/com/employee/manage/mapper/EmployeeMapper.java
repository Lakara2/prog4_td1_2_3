package com.employee.manage.mapper;

import com.employee.manage.Dto.AddressDto;
import com.employee.manage.Dto.EmployeeDto;
import com.employee.manage.Model.Address;
import com.employee.manage.Model.Cin;
import com.employee.manage.Model.Email;
import com.employee.manage.Model.Employee;
import com.employee.manage.Model.response.UpdateEmployeeResponse;
import com.employee.manage.utils.Convert;
import com.employee.manage.utils.Sexe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    public Employee toDomain(EmployeeDto employeeDto) throws IOException {
        MultipartFile file = employeeDto.getProfilePhoto();
        byte[] bytes = file.getBytes();
        String image = Base64.getEncoder().encodeToString(bytes);
        Address address = new Address();
        Cin cin = new Cin();
        Employee employee = new Employee();
        employee.setFirstname(employeeDto.getFirstname());
        employee.setLastname(employeeDto.getLastname());
        employee.setBirthdate(employeeDto.getBirthdate());
        employee.setProfilePhoto(image);
        employee.setAddress(address);
        employee.setPhones(employee.getPhones());

        String sexCode = String.valueOf(employeeDto.getSexe());
        if (sexCode != null && !sexCode.isEmpty()) {
            if (sexCode.equals(Sexe.HOMME.getCode())) {
                employee.setSexe(Sexe.HOMME);
            } else if (sexCode.equals(Sexe.FEMME.getCode())) {
                employee.setSexe(Sexe.FEMME);
            }
        }

        employee.setEmailPerso(employeeDto.getEmailPerso());
        employee.setEmailPro(employeeDto.getEmailPro());
        employee.setCin(cin);
        employee.setRole(employeeDto.getRole());
        employee.setNombreEnfants(employeeDto.getNombreEnfants());
        employee.setDateEmbauche(employeeDto.getDateEmbauche());
        employee.setDateDepart(employeeDto.getDateDepart());
        employee.setCategory(employeeDto.getCategory());
        employee.setNumeroCnaps(employeeDto.getNumeroCnaps());

        return employee;
    }
    public UpdateEmployeeResponse toUpdate(Employee employee) {
        return UpdateEmployeeResponse.builder()
                .id(employee.getId())
                .firstname(employee.getFirstname())
                .lastname(employee.getLastname())
                .birthday(Convert.dateToStringAndFormat(employee.getBirthdate()))
                .sex(employee.getSexe().toString())
                .cnapsNumber(employee.getNumeroCnaps())
                .childrenCount(employee.getNombreEnfants())
                .socioProfessionalCategory(employee.getCategory().toString())
                .function(employee.getRole())
                .startDate(Convert.dateToStringAndFormat(employee.getDateEmbauche()))
                .departureDate(Convert.dateToStringAndFormat(employee.getDateDepart()))
                .addressId(employee.getAddress().getId())
                .addressName(employee.getAddress().getName())
                .addressStreet(employee.getAddress().getStreet())
                .addressCity(employee.getAddress().getCity())
                .addressZipCode(String.valueOf(employee.getAddress()))
                .cinId(employee.getCin().getId())
                .cinNumber(employee.getCin().getCinNumber())
                .cinDeliveryDate(Convert.dateToStringAndFormat(employee.getCin().getCinDeliveryDate()))
                .cinDeliveryPlace(employee.getCin().getCinDeliveryPlace())
                .personalEmailId(employee.getEmailPerso().getId())
                .personalEmail(employee.getEmailPro().getAddress())
                .professionalEmailId(employee.getEmailPerso().getId())
                .professionalEmail(employee.getEmailPro().getAddress())
                .build();
    }

}