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
package com.test.bank.branch.web;

import com.test.bank.branch.model.AccountType;
import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.test.bank.branch.model.Account;

/**
 * @author mszarlinski@bravurasolutions.com on 2016-12-05.
 */
@Data
class AccountDetails {

    private long id;

    private String accountNo;

    private String customer;

    private Double balance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private AccountType type;

    AccountDetails(Account account) {
        this.id = account.getId();
        this.accountNo = account.getAccountNo();
        this.customer = account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName();
        this.type = account.getType();
    }
}
