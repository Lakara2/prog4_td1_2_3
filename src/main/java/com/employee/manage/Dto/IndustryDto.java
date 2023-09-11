package com.employee.manage.Dto;

import com.employee.manage.Model.IndustryAddress;
import com.employee.manage.Model.IndustryPhone;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@Builder
public class IndustryDto {
    private String industryName;
    private String industryDescription;
    private List<IndustryPhone> industryPhone;
    private String industrySlogan;
    private MultipartFile industryLogo;
    private String NIF;
    private String STAT;
    private String RCS;
    private String industryEmail;
    private IndustryAddress industryAddress;
}
