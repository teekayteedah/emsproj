package com.employeemanagementsystem.employeemanagementsystem.repository;
import com.employeemanagementsystem.employeemanagementsystem.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StatusRepository extends JpaRepository<Status, String> {
    //Status findByOpen(String open);
}