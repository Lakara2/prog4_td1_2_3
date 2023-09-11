package com.employee.manage.Repository;

import com.employee.manage.Model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    Phone getByNum(String num);
}
