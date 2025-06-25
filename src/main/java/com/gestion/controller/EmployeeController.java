package com.gestion.controller;

import com.gestion.entity.Employee;
import com.gestion.pagination.PageRender;
import com.gestion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/","/register",""})
    public String employeeList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 1);
        Page<Employee> employees = employeeService.findAll(pageRequest);
        PageRender<Employee> pageRender = new PageRender<>("/register", employees);
        model.addAttribute("title", "Listado de Empleados");
        model.addAttribute("employees", employees);
        model.addAttribute("page", pageRender);

        return "register";
    }
}
