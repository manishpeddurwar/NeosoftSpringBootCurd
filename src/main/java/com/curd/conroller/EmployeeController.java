package com.curd.conroller;

import com.curd.entity.Employee;
import com.curd.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private ServiceI service;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {

        Employee savedEmployee = service.save(emp);

        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> saveEmployee() {

        List<Employee> all = service.getAllEmployees();

        return new ResponseEntity<List<Employee>>(all, HttpStatus.OK);


    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {

        Employee employeeById = service.getEmployeeById(id);

        return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);


    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable Integer id) {

        Employee employee = service.updateEmployee(emp, id);

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);


    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable Integer id){

        String s = service.deleteEmployee(id);

        return new ResponseEntity<String>(s, HttpStatus.OK);


    }







}
