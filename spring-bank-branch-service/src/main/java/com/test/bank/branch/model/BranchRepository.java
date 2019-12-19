package com.test.bank.branch.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

    /**
     * Retrieve all {@link Branch}s from the data store.
     * @return a Collection of {@link Branch}s.
     */
    @Query("SELECT branch FROM Branch branch ORDER BY branch.name")
    List<Branch> findBranches();

    @Query("FROM Branch branch WHERE branch.id = :branchId")
    Optional<Branch> findBranchById(@Param("branchId") int branchId);


}

