package com.employee.manage.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinDto {
    private Integer id;
    private String cinNumber;
    private LocalDate cinDeliveryDate;
    private String cinDeliveryPlace;
}
