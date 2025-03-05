package com.gestion.service;

import com.gestion.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> findAll();

    public Page<Employee> findAll(Pageable pageable);

    public void save (Employee employee);

    public Employee findById (Long id);

    public void delete(Long id);
}
