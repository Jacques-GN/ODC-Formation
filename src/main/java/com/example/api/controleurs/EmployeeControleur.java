package com.example.api.controleurs;

import org.springframework.web.bind.annotation.*;

import com.example.api.model.Employee;
import com.example.api.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControleur {

    private final EmployeeService employeeService;

    public EmployeeControleur(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // Récupérer tous les employés
    @GetMapping
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // Récupérer un employé par son ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Ajouter un employé
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Modifier un employé
    @PutMapping("/{id}")
    public void updateEmployee(
        @PathVariable Long id,
        @RequestBody Employee employee
    ) {
        employeeService.updateEmployee(id, employee);
    }

    // Supprimer un employé
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}