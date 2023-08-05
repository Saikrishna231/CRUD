package com.example.mysql.controller;

import com.example.mysql.model.Employee;
import com.example.mysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RestController
public class EmployeeController {
    @Autowired

   private EmployeeService employeeService;

//    @GetMapping("/employee")
//    public  List<Employee> getallemps()
//    {
//        return employeeService.getallemps();
//    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getallemps() {
        try {
            List<Employee> employees = new ArrayList<>();

            employeeService.getallemps().forEach(employees::add);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping("/employee/{id}")
//    public Employee getEmployeeById(@PathVariable("id") int id){
//        Employee employeeData =  employeeService.getEmployeeById(id);
//
//       return employeeData;
//    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Optional<Employee> employeeData = Optional.ofNullable(employeeService.getEmployeeById(id));

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @PostMapping("/employee")
//    public void createemployee(@RequestBody Employee e ) {
//        employeeService.createemployee(e);
//
//    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createemployee(@RequestBody Employee product) {
        try {
            Employee employeeResp = employeeService.createemployee(product);

            return new ResponseEntity<>(employeeResp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PutMapping("/employee/{id}")
//    public void updateemployee(@RequestBody Employee employee){
//        employeeService.updateEmployee(employee);
//    }


//    @PutMapping("/employee/{id}")
//    public ResponseEntity<Employee>  updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
//        Optional<Employee> employeeData = Optional.ofNullable(employeeService.getEmployeeById(id));
//
//        if(employeeData.isPresent()){
//            Employee employeeValue = employeeData.get();
//            employeeValue.setEmail(employee.getEmail());
//            employeeValue.setName(employee.getName());
//            return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp){
        return new ResponseEntity<>(employeeService.updateEmployee(id,emp),HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            employeeService.deleteAllEmployees();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Integer id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }








}
