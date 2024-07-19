package com.employeemanagementsystem.employeemanagementsystem.controller;

import com.employeemanagementsystem.employeemanagementsystem.entity.Salary;
import com.employeemanagementsystem.employeemanagementsystem.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salaries")
@CrossOrigin("*")
public class SalaryController {

    @GetMapping("/getSalaries")
    public Salary getSalary(@RequestBody Salary amount){
        return amount;
    }

    @PostMapping("/post")
    public Salary post(@RequestBody Salary amount){
        return amount;
    }


    @Autowired
    private SalaryService salaryService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable Long id) {
        return salaryService.getSalaryById(id);
    }

    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryService.saveSalary(salary);
    }

    @PutMapping("/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody Salary salary) {
        Salary existingSalary = salaryService.getSalaryById(id);
        if (existingSalary != null) {
            existingSalary.setAmount(salary.getAmount());
            return salaryService.saveSalary(existingSalary);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
    }
}
