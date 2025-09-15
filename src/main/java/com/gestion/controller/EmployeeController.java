package com.gestion.controller;

import com.gestion.entity.Employee;
import com.gestion.pagination.PageRender;
import com.gestion.reports.EmployeeExportPDF;
import com.gestion.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

        model.put("employee", employee);
        model.put("title", "Detalles del Empleado " + employee.getName());

        return "details";
    }

    @GetMapping({"/","/register",""})
    public String employeeList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
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
        model.put("employee", employee);
        model.put("title", "Registro de Empleados");

        return "form";
    }

    @PostMapping("/form")
    public String saveEmployee(@Valid Employee employee, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Registro de Empleados");
            return "form";
        }

        String message = (employee.getId() != null) ? "El empleado ha sido editado con exito" : "Empleado registrado con exito";

        employeeService.save(employee);
        status.setComplete();
        flash.addFlashAttribute("success", message);
        return "redirect:/register";
    }

    @GetMapping("/form/{id}")
    public String editEmployee(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Employee employee = null;
        if (id > 0) {
            employee = employeeService.findById(id);
            if (employee == null) {
                flash.addFlashAttribute("error", "El ID del empleado no existe en la base de datos");
                return "redirect:/register";
            }
        }
        else {
            flash.addFlashAttribute("error", "El ID del empleado no puede ser cero");
            return "redirect:/register";
        }

        model.put("employee", employee);
        model.put("title", "Edicion de Empleados");
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            employeeService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado con exito");
        }
        return "redirect:/register";
    }

    @GetMapping("/exportPDF")
    public void exportEmployeePdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String actualDate = dateFormat.format(new Date());

        String header = "Content-disposition";
        String value = "attachment; filename=Empleados_" + actualDate + ".pdf";

        response.setHeader(header, value);

        List<Employee> employees = employeeService.findAll();

        EmployeeExportPDF exportPDF = new EmployeeExportPDF(employees);
        exportPDF.export(response);
    }

    @GetMapping("/exportExcel")
    public void exportEmployeeExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String actualDate = dateFormat.format(new Date());

        String header = "Content-disposition";
        String value = "attachment; filename=Empleados_" + actualDate + ".pdf";

        response.setHeader(header, value);

        List<Employee> employees = employeeService.findAll();

        EmployeeExportPDF exportPDF = new EmployeeExportPDF(employees);
        exportPDF.export(response);
    }
}
