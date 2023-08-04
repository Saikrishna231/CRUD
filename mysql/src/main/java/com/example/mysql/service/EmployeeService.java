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
    public void createemployee(Employee e) {
        employeeRepository.save(e);

    }

//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }



//    public Iterable<Employee> findAll() {
//        return null;
//    }


//    public List<Employee> getAllEmployees(){
//        List<Employee> employees = new ArrayList<Employee>();
//        employeeRepository.findAll().forEach(employees::add);
//
//        return employees;
//    }
//
//    public EmployeeService(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
////    public List<Employee> getAllEmployees() {
////        return employeeRepository.findAll();
////    }
////    public Employee getEmployeeById(int id) {
////        return employeeRepository.findById(id).orElse(null);
////    }
//
//    public Optional<Employee> getEmployeeById(int id) {
//        return employeeRepository.findById(id);
//    }
//
//    public Employee addEmployee(Employee employee) {
//        // You can add additional business logic here before saving the employee
//        return employeeRepository.save(employee);
//    }
}
