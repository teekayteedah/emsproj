package com.employeemanagementsystem.employeemanagementsystem.repository;

import com.employeemanagementsystem.employeemanagementsystem.entity.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface GrievanceRepo extends JpaRepository<Grievance, Long> {
    Grievance findByEmail(String email);

}
