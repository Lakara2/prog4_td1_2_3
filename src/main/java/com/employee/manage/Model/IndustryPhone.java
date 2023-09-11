package com.employee.manage.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;


@Entity
@Getter
@Setter
@ToString
@Table(name = "\"industry_phone\"")
public class IndustryPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Pattern(regexp = "^(032|033|034|038)\\d{7}$", message = "Le numéro de téléphone doit commencer par 032, 033, 034 ou 038 et contenir exactement 10 chiffres.")
    private String num;
    @ManyToOne
    @JoinColumn(name = "industry_id")
    private IndustryConf industry;
}
