package com.employee.manage.Service;

import com.employee.manage.Model.Email;
import com.employee.manage.Repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private EmailRepository emailRepository;

    public Email save(Email email) {
        return emailRepository.save(email);
    }

    public Email update(Email email) {
        return emailRepository.save(email);
    }
}
