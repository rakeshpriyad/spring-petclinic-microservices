package com.test.bank.branch.web;

import com.test.bank.branch.model.AccountRepository;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.test.bank.branch.model.Account;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 */
@RequestMapping("/account")
@RestController
@Timed("petclinic.owner")
@RequiredArgsConstructor
@Slf4j
class AccountController {

	@Autowired
    private AccountRepository accountRepository;
	
    /**
     * Create Account
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }

    /**
     * Read single Account
     */
    @GetMapping(value = "/{accountId}")
    public Optional<Account> findAccount(@PathVariable("accountId") int accountId) {
        return accountRepository.findById(accountId);
    }

    /**
     * Read List of Owners
     */
    @GetMapping
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    /**
     * Update Owner
     */
    @PutMapping(value = "/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable("accountId") int accountId, @Valid @RequestBody AccountRequest accountRequest) {
        final Optional<Account> account = accountRepository.findById(accountId);

        final Account accountModel = account.orElseThrow(() -> new ResourceNotFoundException("Customer "+accountId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        accountModel.setAccountNo(accountRequest.getAccountNo());

        log.info("Saving Account {}", accountModel);
        accountRepository.save(accountModel);
    }
}
