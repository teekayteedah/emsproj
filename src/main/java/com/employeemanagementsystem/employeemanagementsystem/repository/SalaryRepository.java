package com.employeemanagementsystem.employeemanagementsystem.repository;


import com.employeemanagementsystem.employeemanagementsystem.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {


}