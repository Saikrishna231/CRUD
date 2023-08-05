package com.example.mysql.service;

import com.example.mysql.model.Employee;
import com.example.mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee>  getallemps() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
       return employeeRepository.findById(id).orElse(null);
   }


    public Employee createemployee(Employee employee) {
         return employeeRepository.save(employee);
    }

//    public Employee createemployee(Employee employee) {
//        return employeeRepository.save(new Employee(employee.getEmail(),employee.getName()));
//    }

    public Employee updateEmployee(int id,Employee employee){
//
        Employee emp = employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        return employeeRepository.save(emp);
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }



//    public Employee updateEmployee(Employee employee) {
//        return employeeRepository.save(new Employee(employee.getId(), employee.getEmail(), employee.getName()));
//
//    }









}
