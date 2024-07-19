package com.employeemanagementsystem.employeemanagementsystem.service;


import com.employeemanagementsystem.employeemanagementsystem.entity.Grievance;

import java.util.List;

public interface ServiceGrievance {
    List<Grievance> getGrievance();
//    Grievance createGrievance(Grievance grievance);



//    List<Grievance>findAll();

    Grievance saveGrievance(Grievance grievance);

    Grievance getGrievanceByEmail(String email);
    Grievance updateGrievanceDetails(long id,Grievance grievance);
    Grievance getGrievanceDetailsById(long id);
}
