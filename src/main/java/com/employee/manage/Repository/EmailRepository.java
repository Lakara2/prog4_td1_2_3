package com.employee.manage.Repository;

import com.employee.manage.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    Email getByAddress(String address);
}
