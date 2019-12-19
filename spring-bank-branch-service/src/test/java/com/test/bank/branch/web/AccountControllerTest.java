package com.test.bank.branch.web;
import com.test.bank.branch.model.Branch;
import com.test.bank.branch.model.BranchRepository;
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
@WebMvcTest(BranchController.class)
@ActiveProfiles("test")
class BranchControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    BranchRepository branchRepository;

    @Test
    void shouldGetAccountInJSonFormat() throws Exception {
        Branch branch = setupBranch();

        given(branchRepository.findById(2)).willReturn(java.util.Optional.of(branch));
        mvc.perform(get("/account/2").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.accountNo").value("SYN00101"))
            .andExpect(jsonPath("$.type.id").value(6));
    }

    private Branch setupBranch() {
        Branch branch = new Branch();
        branch.setName("Delhi");
        return branch;
    }
}
