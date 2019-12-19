package com.test.bank.branch.web;

import com.test.bank.branch.model.Account;
import com.test.bank.branch.model.AccountType;
import com.test.bank.branch.model.Customer;
import com.test.bank.branch.model.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@ActiveProfiles("test")
class CustomerControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    CustomerRepository customerRepository;

    @Test
    void shouldGetAccountInJSonFormat() throws Exception {
        Customer customer = setupCustomer();
        given(customerRepository.findById(2)).willReturn(Optional.of(customer));
        mvc.perform(get("/customer/2").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.firstName").value("Rajesh"))
            .andExpect(jsonPath("$.lastName").value("Kumar"))
            .andExpect(jsonPath("$.address").value("RajPuram"))

           .andExpect(jsonPath("$.account[0].accountNo").value("SYN00102"))
            .andExpect(jsonPath("$.account[0].type.id").value(6));
    }

    private Customer setupCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setFirstName("Rajesh");
        customer.setLastName("Kumar");
        customer.setAddress("RajPuram");
        Account account = new Account();
        account.setAccountNo("SYN00102");
        account.setId(2);

        AccountType accountType = new AccountType();
        accountType.setId(6);
        account.setType(accountType);
        customer.addAccount(account);
        return customer;
    }
}
