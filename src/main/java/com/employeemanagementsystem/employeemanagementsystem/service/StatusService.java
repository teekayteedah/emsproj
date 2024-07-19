package com.employeemanagementsystem.employeemanagementsystem.service;

import com.employeemanagementsystem.employeemanagementsystem.entity.Status;
import com.employeemanagementsystem.employeemanagementsystem.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Optional<Status> getStatusByGrievanceId(String statusId) {
        // TODO Auto-generated method stub
        
            return statusRepository.findById(statusId);
        }

    public List<Status> getAllStatusByGrievance() {
        // TODO Auto-generated method stub

        return statusRepository.findAll();
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
        // TODO Auto-generated method stub
      }
     //PUT
    //  public Status updateStatus(Status status) {
    //     System.out.println("updates");
    //     Status existing_status = statusRepository.findByStatus(status.getOpen());
    //     .orElse(null)

    public Status createStatus(Status status) {
        // TODO Auto-generated method stub

        return statusRepository.save(status);
   }

   public Status updateStatus(Status status) {
        return statusRepository.save(status);
   }
        
    //     existing_status.setStatus(status.getStatus());
    //     return StatusRepository.save(existing_status);
    // }
    // Implement business logic methods
}
