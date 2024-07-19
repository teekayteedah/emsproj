package com.employeemanagementsystem.employeemanagementsystem.repository;
;
import com.employeemanagementsystem.employeemanagementsystem.entity.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Long> {

}
