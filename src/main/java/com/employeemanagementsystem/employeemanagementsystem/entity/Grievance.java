package com.employeemanagementsystem.employeemanagementsystem.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Table(name = "Grievance")
@Entity
@Data
@NoArgsConstructor

public class Grievance {
    //private GrievanceStatus status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//to generate Id's for every instance logged
    private Long id;

    @Column(nullable = false)
    private String email;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date createdDate;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 30)
     private String status;

}
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "user_id")//pass the user_id of the column you want saved
//    private User user;//specifies the table to get data from
//}
