/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.bank.branch.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emp_no")
    private String empNo;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "age")
    private String age;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", empNo='" + empNo + '\'' +
            ", empName='" + empName + '\'' +
            ", age='" + age + '\'' +
            ", dob=" + dob +
            ", branch=" + branch +
            ", address=" + address +
            '}';
    }

    public Integer getId() {
        return id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Branch getBranch() {
        return branch;
    }

    public Address getAddress() {
        return address;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
