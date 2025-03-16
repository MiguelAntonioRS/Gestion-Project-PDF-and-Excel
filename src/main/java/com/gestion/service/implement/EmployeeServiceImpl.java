package com.gestion.service.implement;

import com.gestion.entity.Employee;
import com.gestion.persistence.EmployeeDAO;
import com.gestion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeDAO.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }
}
