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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/show/{id}")
    public String seeDetailsEmployee(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            flash.addFlashAttribute("Error", "El empleado no Existe");
            return "redirect:/register";
        }

        model.put("Empleado", employee);
        model.put("title", "Detalles del Empleado " + employee.getName());

        return "details";
    }

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

    @GetMapping("/form")
    public String showForm(Map<String, Object> model) {

        Employee employee = new Employee();
        model.put("Empleado", employee);
        model.put("title", "Registro de Empleados");

        return "form";
    }
}
