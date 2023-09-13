package com.curd.service;

import com.curd.entity.Employee;
import com.curd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service

public class ServiceImpl implements ServiceI {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee save(Employee emp) {
        Employee save = repo.save(emp);
        return save;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> all = repo.findAll();
        return all;
    }


    public Employee getEmployeeById(Integer id) {
        Optional<Employee> byId = repo.findById(id);

        if (byId.isPresent()) {
            Employee employee = byId.get();
            System.out.println(employee);
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee emp, Integer id) {

        Optional<Employee> byId = repo.findById(id);

        if (byId.isPresent()) {
            Employee employee = byId.get();
            employee.setName(emp.getName());
            employee.setLocation(emp.getLocation());

            return repo.save(employee);
        } else {
            return null;
        }


    }

    @Override
    public String deleteEmployee(Integer id) {

        repo.deleteById(id);

        return "Employee deleted successfully";

    }


}


