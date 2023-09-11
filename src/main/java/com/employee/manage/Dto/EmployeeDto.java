package com.employee.manage.Dto;

import com.employee.manage.Model.Address;
import com.employee.manage.Model.Cin;
import com.employee.manage.Model.Email;
import com.employee.manage.utils.Sexe;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeDto {
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private MultipartFile profilePhoto;
    private Address address;
    private Sexe sexe;
    private String phone;
    private Email emailPerso;
    private Email emailPro;
    private Cin cin;
    private String role;
    private int nombreEnfants;
    private LocalDate dateEmbauche;
    private LocalDate dateDepart;
    private String category;
    private String numeroCnaps;
}
