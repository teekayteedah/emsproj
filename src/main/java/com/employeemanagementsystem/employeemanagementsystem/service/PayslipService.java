package com.employeemanagementsystem.employeemanagementsystem.service;

import com.employeemanagementsystem.employeemanagementsystem.entity.Payslip;
import com.employeemanagementsystem.employeemanagementsystem.repository.PayslipRepository;
import com.employeemanagementsystem.employeemanagementsystem.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    public List<Payslip> getAllPayslips() {
        return payslipRepository.findAll();
    }

    public Payslip getPayslipById(Long id) {
        return payslipRepository.findById(id).orElse(null);
    }

    public Payslip savePayslip(Payslip payslip) {
        return payslipRepository.save(payslip);
    }

    public void deletePayslip(Long id) {
        payslipRepository.deleteById(id);
    }


}
