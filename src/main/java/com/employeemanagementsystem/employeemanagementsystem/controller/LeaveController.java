package com.employeemanagementsystem.employeemanagementsystem.controller;


import com.employeemanagementsystem.employeemanagementsystem.entity.LeaveDetails;
import com.employeemanagementsystem.employeemanagementsystem.service.LeaveService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/api/leaves/LeaveController")
@CrossOrigin("*")
public class LeaveController
{
    @Autowired
    private LeaveService leaveService;
//
//    @Autowired
//    private UserRepository userRepository;
@Autowired
public LeaveController(LeaveService leaveService) {
    this.leaveService = leaveService;
}

    @PostMapping("/applyLeave")
    public LeaveDetails applyLeave(@RequestBody LeaveDetails leaveDetails)
    {
        return   leaveService.applyLeave(leaveDetails);

    }

    @GetMapping("/getLeaveDetails")
    public ResponseEntity<List<LeaveDetails>> getAllLeaves()
    {
        List<LeaveDetails> leaves = leaveService.getAllLeaves();
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<LeaveDetails>
//    getLeaveDetailsOnId(@PathVariable long id)
//    {
//        LeaveDetails leaveDetails = leaveService.getLeaveDetailsOnId(id);
//        if (leaveDetails == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(leaveDetails,
//                HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveDetails> updateLeaveDetails(@PathVariable long id, @RequestBody LeaveDetails leaveDetails) {
        try {
            LeaveDetails updatedLeaveDetails = leaveService.updateLeaveDetails(id, leaveDetails);
            return ResponseEntity.ok(updatedLeaveDetails);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/LeaveStatusByID/{id}")
    public ResponseEntity<LeaveDetails> getLeaveDetailsById(@PathVariable long id) {
        LeaveDetails leaveDetails = leaveService.getLeaveDetailsOnId(id);
        if (leaveDetails != null) {
            return ResponseEntity.ok(leaveDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Void> updateLeaveRequestStatus(@PathVariable Long id, @RequestParam String status) {
//        leaveRequestService.updateLeaveRequestStatus(id, status);
//        return ResponseEntity.noContent().build();
//    }


//    public ResponseEntity<Void> updateLeaveRequestStatus(@PathVariable Long id,
//                                                         @RequestParam String status)
//    {
//        leaveService.updateLeaveRequestStatus(id,status);
//        return ResponseEntity.noContent().build();
//
//
//
//    }

    //    @PutMapping("/{id}/status")
    @PutMapping("/{id}/status")
    public ResponseEntity<LeaveDetails> updateLeaveRequestStatus(@PathVariable Long id,
                                                                 @RequestParam String status)
    {
        LeaveDetails updatedLeaveDetail = leaveService.updateLeaveRequestStatus(id, status);
        return ResponseEntity.ok(updatedLeaveDetail);


    }

//    @PutMapping("/updateLeaveDetails/{id}")
//    public ResponseEntity<LeaveDetails>
//    updateLeaveDetails(@PathVariable long id, @RequestBody LeaveDetails leaveDetails)
//    {
//        try {
//            LeaveDetails updatedLeaveDetails =
//                    leaveService.updateLeaveDetails(id, leaveDetails);
//            if (updatedLeaveDetails == null)
//            {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(updatedLeaveDetails,
//                    HttpStatus.OK);
//        } catch (Exception e)
//        {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
