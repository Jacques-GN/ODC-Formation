package com.example.api.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.model.Employee;
import com.example.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Récupérer un employé par son ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Employé introuvable"
            )
        );
    }

    // Récupérer tous les employés
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // Ajouter un employé
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Modifier un employé
    public void updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);
    }

    // Supprimer un employé
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Compter les employés
    public long countEmployees() {
        return employeeRepository.count();
    }

    //Mise a jour complete (PUT) sans trop de if

    // Mise a jour sequentiel avec plusieur if
    
}