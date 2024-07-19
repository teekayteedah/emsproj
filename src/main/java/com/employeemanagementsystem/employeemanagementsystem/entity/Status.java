package com.employeemanagementsystem.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "STATUSES")



public class Status {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   private String Open;
    private String IN_PROGRESS;
    private String RESOLVED;
    private String CLOSED;


    @ManyToOne
    @JoinColumn(name = "Grievance_id")
    private Grievance grievance;// status of the grievance(e.g OPEN,IN_PROGRESS< RESOLVED, CLOSED)


    
//    public Object getStatus() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
//    }
//    public void setStatus(Object status) {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
//    }
//    public String getStatusByGrievanceId() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getStatusByGrievanceId'");
//    }

}

    //    // No need for getters and setters for id and name, as @Data annotation generates them
////    private String description;
//
//
//
//    public GrievanceCategory() {
//
//    }
//
//
//
//
//}