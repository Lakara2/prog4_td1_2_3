package com.employee.manage.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeResponse {
    private Long id;

    private String personnelNumber;

    private String firstname;

    private String lastname;

    private String birthday;

    private String sex;

    private String cnapsNumber;

    private Integer childrenCount;

    private String socioProfessionalCategory;

    private String function;

    private String startDate;

    private String departureDate;

    private Integer id_image;

    private Integer addressId;
    private String addressName;
    private String addressStreet;
    private String addressCity;
    private String addressZipCode;

    private Integer cinId;
    private String cinNumber;
    private String cinDeliveryDate;
    private String cinDeliveryPlace;

    private Integer personalEmailId;
    private String personalEmail;

    private Integer professionalEmailId;
    private String professionalEmail;
}
