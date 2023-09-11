package com.employee.manage.Repository;

import com.employee.manage.Model.IndustryConf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepository extends JpaRepository<IndustryConf, Long> {
    IndustryConf findFirstByOrderById();
}

