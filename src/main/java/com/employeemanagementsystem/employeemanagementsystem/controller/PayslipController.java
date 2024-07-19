package com.employeemanagementsystem.employeemanagementsystem.controller;

import com.employeemanagementsystem.employeemanagementsystem.entity.Payslip;
import com.employeemanagementsystem.employeemanagementsystem.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @GetMapping("auth/getPayslip")
    public List<Payslip> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

    @GetMapping("auth/getPayslipById/{id}")
    public Payslip getPayslipById(@PathVariable Long id) {
        return payslipService.getPayslipById(id);
    }

    @PostMapping("/auth/save")
    public Payslip createPayslip(@RequestBody Payslip payslip) {
        return payslipService.savePayslip(payslip);
    }

    @PutMapping("/{id}")
    public Payslip updatePayslip(@PathVariable Long id, @RequestBody Payslip payslip) {
        Payslip existingPayslip = payslipService.getPayslipById(id);
        if (existingPayslip != null) {
            existingPayslip.setGrossPay(payslip.getGrossPay());
            existingPayslip.setDeductions(payslip.getDeductions());
            return payslipService.savePayslip(existingPayslip);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePayslip(@PathVariable Long id) {
        payslipService.deletePayslip(id);
    }
}