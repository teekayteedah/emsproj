package com.employeemanagementsystem.employeemanagementsystem.service;


import com.employeemanagementsystem.employeemanagementsystem.entity.Grievance;
import com.employeemanagementsystem.employeemanagementsystem.entity.LeaveDetails;
import com.employeemanagementsystem.employeemanagementsystem.repository.GrievanceRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGrievanceImpl implements ServiceGrievance {
    private final GrievanceRepo grievanceRepo;
    @Autowired
    public ServiceGrievanceImpl(GrievanceRepo grievanceRepo) {
        this.grievanceRepo = grievanceRepo;
    }

    @Override
    public List<Grievance> getGrievance() {
        return grievanceRepo.findAll();
    }

    @Override
    public Grievance saveGrievance(Grievance grievance){
        return grievanceRepo.save(grievance);
    }

    @Override
    public Grievance getGrievanceByEmail(String email) {
        return grievanceRepo.findByEmail(email);
    }


    @Override
    public Grievance getGrievanceDetailsById(long id) {
        return grievanceRepo.findById(id).orElse(null);
    }

    @Override
    public Grievance updateGrievanceDetails(long id, Grievance grievance) {
        return grievanceRepo.findById(id)
                .map(existingGrievanceDetails -> {
                    existingGrievanceDetails.setEmail(grievance.getEmail());
                    existingGrievanceDetails.setTitle(grievance.getTitle());
                    existingGrievanceDetails.setDescription(grievance.getDescription());
                    existingGrievanceDetails.setCreatedDate(grievance.getCreatedDate());
                    existingGrievanceDetails.setStatus(grievance.getStatus());
                    return grievanceRepo.save(existingGrievanceDetails);
                })
                .orElseThrow(() -> new EntityNotFoundException("LeaveDetails not found with id: " + id));
    }
}