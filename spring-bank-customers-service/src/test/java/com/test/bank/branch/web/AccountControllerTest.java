package com.test.bank.branch.web;
import com.test.bank.branch.model.Account;
import com.test.bank.branch.model.AccountRepository;
import com.test.bank.branch.model.AccountType;
import com.test.bank.branch.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    AccountRepository accountRepository;

    @Test
    void shouldGetAccountInJSonFormat() throws Exception {
        Account account = setupAccount();

        given(accountRepository.findById(2)).willReturn(java.util.Optional.of(account));
        mvc.perform(get("/account/2").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.accountNo").value("SYN00101"))
            .andExpect(jsonPath("$.type.id").value(6));
    }

    private Account setupAccount() {
        Customer customer = new Customer();
        customer.setFirstName("Rakesh");
        customer.setLastName("Kumar");

        Account account = new Account();
        account.setAccountNo("SYN00101");
        account.setId(2);

        AccountType accountType = new AccountType();
        accountType.setId(6);
        account.setType(accountType);
        customer.addAccount(account);
        return account;
    }
}
