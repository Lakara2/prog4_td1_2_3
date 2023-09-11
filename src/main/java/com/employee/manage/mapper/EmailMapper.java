package com.employee.manage.mapper;

import com.employee.manage.Dto.EmailDto;
import com.employee.manage.Model.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public Email toEntity(Integer id, String address) {
        Email email = new Email();
        email.setId(id);
        email.setAddress(address);
        return email;
    }

    public EmailDto fromEntity(Email email) {
        return EmailDto.builder()
                .id(email.getId())
                .address(email.getAddress())
                .build();
    }
}
