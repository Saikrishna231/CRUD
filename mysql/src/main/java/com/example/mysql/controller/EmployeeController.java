package com.example.mysql.controller;

import com.example.mysql.model.Employee;
import com.example.mysql.repository.EmployeeRepository;
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

    @GetMapping("/employee")
    public  List<Employee> getallemps()
    {
        return employeeService.getallemps();


    }
    @PostMapping("/employee")
    public void createemployee(@RequestBody Employee e ) {
        employeeService.createemployee(e);

    }


//    @GetMapping("/employees")
//    public ResponseEntity<List<Employee>> getAllEmployee() {
//        try {
//            List<Employee> products = new ArrayList<>();
//
//            employeeService.getAllEmployees().forEach(products::add);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
//        Optional<Employee> employeeData = employeeService.getEmployeeById((int) id);
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
