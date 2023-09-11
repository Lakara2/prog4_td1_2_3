package com.employee.manage.Model.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.employee.manage.Model.IndustryConf;
import com.employee.manage.Model.IndustryPhone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateIndustryResponse {
    @NotBlank(message = "name is mandatory")
    @NotNull(message = "name is mandatory")
    private String industryName;

    @NotBlank(message = "description is mandatory")
    @NotNull(message = "description is mandatory")
    private String industryDescription;

    @NotBlank(message = "slogan is mandatory")
    @NotNull(message = "slogan is mandatory")
    private String industrySlogan;

    @Email(message = "Personal email is not well formed")
    @NotNull(message = "Professional email is mandatory")
    @NotBlank(message = "Professional email is mandatory")
    private String industryEmail;

    //    ----------------- Address Information --------------------
    @NotNull(message = "The house is mandatory")
    @NotBlank(message = "The house is mandatory")
    private String addressName;

    @NotNull(message = "The street is mandatory")
    @NotBlank(message = "The street is mandatory")
    private String addressStreet;

    @NotNull(message = "The city is mandatory")
    @NotBlank(message = "The city is mandatory")
    private String addressCity;

    @NotNull(message = "The zipCode is mandatory")
    @NotBlank(message = "The zipCode is mandatory")
    @Pattern(regexp = "[0-9]+", message = "The zipCode must contain only numbers")
    private String addressZipCode;
    //    --------------- Address Information ---------------------

    @Pattern(regexp = "^[0-9+,]+$", message = "phones not well formed")
    @NotNull(message = "phones is mandatory")
    @NotBlank(message = "phones is mandatory")
    private IndustryPhone industryPhone;
}
