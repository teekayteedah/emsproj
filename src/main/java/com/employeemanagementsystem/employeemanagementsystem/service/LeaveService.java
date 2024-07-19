package com.employeemanagementsystem.employeemanagementsystem.service;

import com.employeemanagementsystem.employeemanagementsystem.entity.LeaveDetails;
import com.employeemanagementsystem.employeemanagementsystem.repository.LeaveRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LeaveService
{
    @Autowired
    private LeaveRepository leaveRepository;


//    public void updateLeaveRequestStatus(Long id, String status)
//    {
//        leaveRepository.findById(id).ifPresent(leaveDetails ->
//                leaveDetails.setStatus(status));
//    }

//    public LeaveDetails updateLeaveRequestStatus(Long id, String status) {
//        return leaveRepository.findById(id)
//                .map(leaveDetails -> {
//                    leaveDetails.setStatus(status);
//                    return leaveRepository.save(leaveDetails);
//                })
//                .orElseThrow(() -> new ResourceNotFoundException(""));
//    }

//    public LeaveDetails updateLeaveRequestStatus(Long id, String status){
//        Optional<LeaveDetails> leaveDetails = leaveRepository.findById(id);
//        leaveDetails.
//    }

    public LeaveDetails updateLeaveRequestStatus(Long id,String status){


        LeaveDetails leaveDetails = leaveRepository.findById(id).orElseThrow();
        leaveDetails.setStatus(leaveDetails.getStatus());
        leaveDetails.setStatus(status);
        return leaveRepository.save(leaveDetails);
    }

//    public void updateStatus(Long id, String newStatus)
//    {
//        Optional<LeaveDetails> leaveDetailOptional = leaveRepository.findById(id);
//        if (leaveDetailOptional.isPresent())
//        {
//            LeaveDetails leaveDetail = leaveDetailOptional.get();
//            leaveDetail.setStatus(newStatus);
//            leaveRepository.save(leaveDetail);
//        }
//    }

    public LeaveDetails applyLeave(LeaveDetails leaveDetails)
    {
        return leaveRepository.save(leaveDetails);
    }

    public List<LeaveDetails> getAllLeaves()
    {
        return leaveRepository.findAll();
    }

    public LeaveDetails getLeaveDetailsOnId(long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public LeaveDetails updateLeaveDetails(long id, LeaveDetails leaveDetails) {
        return leaveRepository.findById(id)
                .map(existingLeaveDetails -> {
                    existingLeaveDetails.setName(leaveDetails.getName());
                    existingLeaveDetails.setLeaveType(leaveDetails.getLeaveType());
                    existingLeaveDetails.setStartDate(leaveDetails.getStartDate());
                    existingLeaveDetails.setEndDate(leaveDetails.getEndDate());
                    existingLeaveDetails.setReason(leaveDetails.getReason());
                    existingLeaveDetails.setStatus(leaveDetails.getStatus());
                    return leaveRepository.save(existingLeaveDetails);
                })
                .orElseThrow(() -> new EntityNotFoundException("LeaveDetails not found with id: " + id));
    }


}
