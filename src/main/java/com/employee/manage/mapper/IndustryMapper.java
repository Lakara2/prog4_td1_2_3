package com.employee.manage.mapper;

import com.employee.manage.Dto.IndustryDto;
import com.employee.manage.Model.IndustryAddress;
import com.employee.manage.Model.IndustryConf;
import com.employee.manage.Model.IndustryPhone;
import com.employee.manage.Model.response.CreateOrUpdateIndustryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.employee.manage.utils.Convert.stringToIndustryPhone;

@Component
@AllArgsConstructor
public class IndustryMapper {
    public IndustryConf toDomain(IndustryDto industryDto) throws IOException {
        MultipartFile file = industryDto.getIndustryLogo();
        byte[] bytes = file.getBytes();
        String image = Base64.getEncoder().encodeToString(bytes);
        IndustryConf industryConf = new IndustryConf();
        industryConf.setIndustryName(industryDto.getIndustryName());
        industryConf.setIndustryDescription(industryDto.getIndustryDescription());
        industryConf.setIndustryPhone(industryConf.getIndustryPhone());
        industryConf.setIndustrySlogan(industryDto.getIndustrySlogan());
        industryConf.setIndustryLogo(image.getBytes());
        industryConf.setNIF(industryDto.getNIF());
        industryConf.setSTAT(industryDto.getSTAT());
        industryConf.setRCS(industryDto.getRCS());
        industryConf.setIndustryEmail(industryDto.getIndustryEmail());
        industryConf.setIndustryAddress(industryDto.getIndustryAddress());

        return industryConf;
    }
    public IndustryConf toEntity(CreateOrUpdateIndustryResponse createResponse) {
        IndustryConf industry = new IndustryConf();
        industry.setIndustryName(createResponse.getIndustryName());
        industry.setIndustryDescription(createResponse.getIndustryDescription());
        industry.setIndustrySlogan(createResponse.getIndustrySlogan());
        industry.setIndustryAddress(new IndustryAddress(
                createResponse.getAddressName(),
                createResponse.getAddressStreet(),
                createResponse.getAddressCity(),
                createResponse.getAddressZipCode()));
        industry.setIndustryEmail(createResponse.getIndustryEmail());
        industry.setIndustryPhone(this.getPhonesNumberList((List<String>) createResponse.getIndustryPhone()));
        return industry;
    }

    private List<IndustryPhone> getPhonesNumberList(List<String> phoneNumbers) {
        List<IndustryPhone> phones = new ArrayList<>();

        for (String phoneNumber : phoneNumbers) {
            IndustryPhone industryPhone = stringToIndustryPhone(phoneNumber);
            if (industryPhone != null) {
                phones.add(industryPhone);
            }
        }

        return phones;
    }
    public IndustryConf toEntity(IndustryDto industryDto) {
        IndustryConf industry = new IndustryConf();
        industry.setIndustryName(industryDto.getIndustryName());
        industry.setIndustryDescription(industryDto.getIndustryDescription());
        industry.setIndustrySlogan(industryDto.getIndustrySlogan());
        industry.setIndustryAddress(industryDto.getIndustryAddress());
        industry.setIndustryEmail(industry.getIndustryEmail());
        industry.setIndustryPhone(industryDto.getIndustryPhone());
        return industry;
    }

}