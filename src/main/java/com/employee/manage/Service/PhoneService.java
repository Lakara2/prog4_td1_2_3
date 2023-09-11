package com.employee.manage.Service;

import com.employee.manage.Model.Employee;
import com.employee.manage.Model.Phone;
import com.employee.manage.Repository.PhoneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService {
    private PhoneRepository phoneRepository;

    @Transactional
    public List<Phone> saveAll(List<Phone> phones, Employee employee) {
        phones.forEach(phone -> {
            phone.setEmployee(employee);
        });
        return phoneRepository.saveAll(phones);
    }
}
