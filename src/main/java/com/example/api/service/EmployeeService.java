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
    public Employee updateEmployee(final Long id, EmployeeUpdateDTO dto) {
        Employee employee = getEmployee(id);
        if (!employee.getMail().equalsIgnoreCase(dto.getMail()) && employeeRepository.existsByMail(dto.getMail())) {
            throw new EmailAlreadyUsedException(dto.getMail());
        }
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setMail(dto.getMail());
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            employee.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        if (dto.getRole() != null && !dto.getRole().isBlank()) {
            employee.setRole(dto.getRole());
        }
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(final Long id, EmployeeUpdateDTO dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            return null;
        }

        Employee employee = optionalEmployee.get();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setMail(dto.getMail());
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            employee.setPassword(dto.getPassword());
        }

        return employeeRepository.save(employee);
    }

    /**
     * Mise à jour partielle (PATCH).
     */
    public Employee partialUpdate(final Long id, EmployeePatchdto dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            return null;
        }

        Employee employee = optionalEmployee.get();

        if (dto.getFirstName() != null) {
            employee.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            employee.setLastName(dto.getLastName());
        }
        if (dto.getMail() != null) {
            employee.setEmail(dto.getMail());
        }
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            employee.setPassword(dto.getPassword());
        }

        return employeeRepository.save(employee);
    }
    
}