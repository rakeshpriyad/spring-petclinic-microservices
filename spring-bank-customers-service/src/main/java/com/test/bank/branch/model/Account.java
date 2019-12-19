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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple business object representing a pet.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Maciej Szarlinski
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_no")
    private String accountNo;
/*
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;*/

    @ManyToOne
    @JoinColumn(name = "type_id")
    private AccountType type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(final AccountType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("name", this.getAccountNo())
            //.append("birthDate", this.getBirthDate())
            .append("type", this.getType().getName())
            .append("customerFirstName", this.getCustomer().getFirstName())
            .append("customerLastName", this.getCustomer().getLastName())
            .toString();
    }

}
