package com.pract.spring3.controller;

import com.pract.spring3.model.Employee;
import com.pract.spring3.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "API for managing Employee records")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees", description = "Returns a list of all employees")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of employees")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Operation(summary = "Get employee by ID", description = "Returns a single employee based on the provided ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the employee")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @Parameter(description = "The ID of the employee to be fetched") @PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "Create a new employee", description = "Creates a new employee record")
    @ApiResponse(responseCode = "201", description = "Successfully created a new employee")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(
            @Parameter(description = "Employee details to be created") @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @Operation(summary = "Update an existing employee", description = "Updates an employee's details by ID")
    @ApiResponse(responseCode = "200", description = "Successfully updated the employee")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @Parameter(description = "The ID of the employee to be updated") @PathVariable int id,
            @Parameter(description = "Updated employee details") @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @Operation(summary = "Delete an employee", description = "Deletes an employee record by ID")
    @ApiResponse(responseCode = "204", description = "Successfully deleted the employee")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@Parameter(description = "The ID of the employee to be deleted") @PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}