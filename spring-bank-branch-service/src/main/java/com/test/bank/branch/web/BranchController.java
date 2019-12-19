package com.test.bank.branch.web;

import com.test.bank.branch.model.Branch;
import com.test.bank.branch.model.BranchRepository;
import com.test.bank.branch.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 */
@RequestMapping("/branch")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BranchController {

	@Autowired
    private BranchRepository branchRepository;
	
    /**
     * Create Branch
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Branch createBranch(@Valid @RequestBody Branch branch) {
        return branchRepository.save(branch);
    }

    /**
     * Read single Branch
     */
    @GetMapping(value = "/{branchId}")
    public Optional<Branch> findBranch(@PathVariable("branchId") int branchId) {
        return branchRepository.findById(branchId);
    }

    /**
     * Read List of Branch
     */
    @GetMapping
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    /**
     * Update Branch
     */
    @PutMapping(value = "/{branchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBranch(@PathVariable("branchId") int branchId, @Valid @RequestBody BranchRequest branchRequest) {
        final Optional<Branch> branch = branchRepository.findById(branchId);

        final Branch branchModel = branch.orElseThrow(() -> new ResourceNotFoundException("Branch "+branchId+" not found"));
        log.info("Saving Branch {}", branchModel);

        for(Employee emp:  branch.get().getEmployees()) {
            System.out.println(emp.getEmpNo());
        }

        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        branchModel.setName(branchRequest.getName());
        log.info("Saving branch {}", branchModel);

        branchRepository.save(branchModel);
    }
}
