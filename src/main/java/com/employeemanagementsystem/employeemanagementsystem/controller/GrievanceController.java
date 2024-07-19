package com.employeemanagementsystem.employeemanagementsystem.controller;


import com.employeemanagementsystem.employeemanagementsystem.entity.Grievance;
import com.employeemanagementsystem.employeemanagementsystem.entity.LeaveDetails;
import com.employeemanagementsystem.employeemanagementsystem.service.ServiceGrievance;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth/api/GrievanceControl")
public class GrievanceController {
  @Autowired
  private ServiceGrievance serviceGrievance;

  @GetMapping("/grievanceByEmail")
  public Grievance findGrievanceByEmail(@PathVariable String email) {
    return serviceGrievance.getGrievanceByEmail(email);
  }

  public GrievanceController(ServiceGrievance serviceGrievance) {
    this.serviceGrievance = serviceGrievance;
  }
  @PostMapping("/saveGrievance")
  public Grievance saveGrievance(@RequestBody Grievance grievance) {

    return serviceGrievance.saveGrievance(grievance);
  }
  @GetMapping("/AllGrievance")
 public List<Grievance> getAllGrievance() {
    return serviceGrievance.getGrievance();
  }

    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievanceDetails(@PathVariable long id, @RequestBody Grievance grievance) {
        try {
            Grievance updatedGrievanceDetails = serviceGrievance.updateGrievanceDetails(id, grievance);
            return ResponseEntity.ok(updatedGrievanceDetails);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/grievanceStatusByID/{id}")
    public ResponseEntity<Grievance> getGrievanceDetailsById(@PathVariable long id) {
        Grievance grievance = serviceGrievance.getGrievanceDetailsById(id);
        if (grievance != null) {
            return ResponseEntity.ok(grievance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
  }




