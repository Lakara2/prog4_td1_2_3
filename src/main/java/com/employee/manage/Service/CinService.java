package com.employee.manage.Service;

import com.employee.manage.Model.Cin;
import com.employee.manage.Repository.CinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CinService {
    private CinRepository cinRepository;

    public Cin save(Cin cin) {
        return cinRepository.save(cin);
    }

    public Cin update(Cin cin) {
        return cinRepository.save(cin);
    }
}
