package com.employeemanagementsystem.employeemanagementsystem.repository;


import com.employeemanagementsystem.employeemanagementsystem.entity.LeaveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "LeaveDetails")
public interface LeaveRepository extends JpaRepository<LeaveDetails,Long>
{
//    LeaveDetails applyLeave(String name, String leaveType,
//                            LocalDate startDate,
//                            LocalDate endDate, String reason, int userId);


//    List<LeaveDetails> findByStatus(String status);



}
