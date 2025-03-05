package com.gestion.persistence;

import com.gestion.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface EmployeeDAO {

    public List<Employee> findAll();

    public Page<Employee> findAll(Pageable pageable);

    public void save (Employee employee);

    public Employee findById (Long id);

    public void delete(Long id);
}
