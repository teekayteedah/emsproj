package com.employeemanagementsystem.employeemanagementsystem.controller;

import com.employeemanagementsystem.employeemanagementsystem.entity.Status;
import com.employeemanagementsystem.employeemanagementsystem.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService){
        this.statusService= statusService;
    }



    @PostMapping("/create")
    public ResponseEntity<Status> createStatus(@RequestBody Status status){
        Status createStatus = statusService.createStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(createStatus);
    }

    @GetMapping("/{grievanceId}")
    public ResponseEntity<Optional<Status>> getStatusByGrievanceId(@PathVariable String grievanceId) {
        Optional<Status> status = statusService.getStatusByGrievanceId(grievanceId);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/getAllStatusByGrievance")
    public ResponseEntity<List<Status>> getAllStatusByGrievance() {
        List<Status> allStatuses = statusService.getAllStatusByGrievance(); // Assuming you have a method to get all statuses
        return ResponseEntity.ok(allStatuses);
    }
    @PostMapping("/saveStatus")
    public ResponseEntity<Status> saveStatus(@RequestBody Status status) {
        Status savedStatus = statusService.saveStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStatus);
    }

    @PutMapping("/update")
    public ResponseEntity<Status> updateStatus(@RequestBody Status status) {


        Status updatedStatus = statusService.updateStatus(status);
        return ResponseEntity.ok(updatedStatus);
    }


}

