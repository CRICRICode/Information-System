package com.sisinfo.Controller;

import com.sisinfo.Entity.Employee;
import com.sisinfo.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    // Dipendenza del servizio EmployeeService
    private final EmployeeService employeeService;

    // Costruttore
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Metodi per gestire le richieste HTTP relative ai dipendenti
    // ...

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    // Aggiungi altri metodi per gestire le operazioni sui dipendenti
}

