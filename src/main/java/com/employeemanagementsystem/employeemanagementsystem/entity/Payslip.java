package com.employeemanagementsystem.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payslip")
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payslipId;

    @Column(name = "email")
    private String email;

    @Column(name = "gross_Pay")
    private double grossPay;

    @Column(name = "deductions")
    private double deductions;

    @Column(name = "net_Pay")
    private double netPay;



    @Column(name = "pay_period", unique = false)
    private String payPeriod;

    public void setDeductions(double deductions) {
        this.deductions = deductions;
        calculateNetSalary();
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
        calculateNetSalary();
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
        updateGrossPayFromSalary();
    }
    public void updateGrossPayFromSalary() {
        if (this.salary != null) {
            this.grossPay = this.salary.getAmount();
            calculateNetSalary();
        }
    }

    public void calculateNetSalary() {

        this.netPay = this.grossPay- this.deductions;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Salary salary;
}