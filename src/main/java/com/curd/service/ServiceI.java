package com.curd.service;

import com.curd.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ServiceI {


    public Employee save (Employee emp);


    public List<Employee> getAllEmployees();


    public Employee getEmployeeById(Integer id);


    public Employee updateEmployee(Employee emp,Integer id);


    public String deleteEmployee(Integer id);

}
