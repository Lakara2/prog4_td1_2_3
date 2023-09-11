package com.employee.manage.Model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Pattern;


@Entity
@Getter
@Setter
@ToString
@Table(name = "\"employee_phone\"")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Pattern(regexp = "^(032|033|034|038)\\d{7}$", message = "Le numéro de téléphone doit commencer par 032, 033, 034 ou 038 et contenir exactement 10 chiffres.")
    private String num;
    @ManyToOne
    @JoinColumn( name = "employee_id")
    private Employee employee;
}
