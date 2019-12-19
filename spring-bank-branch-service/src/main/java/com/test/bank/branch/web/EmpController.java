package com.test.bank.branch.web;


import javax.validation.Valid;

import com.test.bank.branch.model.EmpRepository;
import com.test.bank.branch.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 */
@RequestMapping("/emp")
@RestController
@RequiredArgsConstructor
@Slf4j
public class EmpController {

	@Autowired
    private EmpRepository empRepository;
	
    /**
     * Create Employee
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmp(@Valid @RequestBody Employee emp) {
        return empRepository.save(emp);
    }

    /**
     * Read single Employee
     */
    @GetMapping(value = "/{empId}")
    public Optional<Employee> findEmp(@PathVariable("empId") int empId) {
        return empRepository.findById(empId);
    }

    /**
     * Read List of Emp
     */
    @GetMapping(value = "/all")
    public List<Employee> findAll() {
        return empRepository.findAll();
    }

    /**
     * Update Employee
     */
    @PutMapping(value = "/{empId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable("empId") int empId, @Valid @RequestBody EmpRequest empRequest) {
        final Optional<Employee> employee = empRepository.findById(empId);

        final Employee employeeModel = employee.orElseThrow(() -> new ResourceNotFoundException("Employee "+empId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        employeeModel.setEmpName(empRequest.getEmpName());
        employeeModel.setEmpNo(empRequest.getEmpNo());
        employeeModel.setAge(empRequest.getAge());
        employeeModel.setDob(empRequest.getDob());
        employeeModel.setAddress(empRequest.getAddress());
        employeeModel.setBranch(empRequest.getBranch());
        log.info("Saving Employee {}", employeeModel);
        empRepository.save(employeeModel);
    }
}
