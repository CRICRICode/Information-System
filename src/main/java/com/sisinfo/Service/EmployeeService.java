package com.sisinfo.Service;

import com.sisinfo.Entity.Employee;
import com.sisinfo.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final double TOTAL_WORK_HOURS_PER_MONTH = 40;
    // Dipendenza del repository necessaria
    private final EmployeeRepository employeeRepository;

    // Costruttore
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public double calculateSalary(Employee employee) {
        // Implementa il calcolo dello stipendio in base alle ore di lavoro e alle ferie/permessi
        double baseSalary = employee.getBaseSalary();
        int workedHours = employee.getWorkedHours();
        int vacationHours = employee.getVacationHours();
        int permissionHours = employee.getPermissionHours();

        double hourlyRate = baseSalary / TOTAL_WORK_HOURS_PER_MONTH;
        double salary = workedHours * hourlyRate - (vacationHours + permissionHours) * hourlyRate;

        return salary;
    }

    public List<Employee> getAllEmployees() {
        return null;
    }

    public List<Employee> getEmployeesSortedByAge() {
        return null;
    }


    // Metodi per gestire la logica di business dei dipendenti
    // Implementa i punti richiesti 1, 2, 5, 6, 7, 8 e 9
    // ...
}

