package com.gestion.controller;

import com.gestion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping({"/","/listar",""})
    public String employeeList(@RequestParam(name = "page", defaultValue = 0) int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
    }
}
