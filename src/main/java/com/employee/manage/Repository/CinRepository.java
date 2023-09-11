package com.employee.manage.Repository;

import com.employee.manage.Model.Cin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinRepository extends JpaRepository<Cin, Integer> {
    Cin getByCinNumber(String number);
}
