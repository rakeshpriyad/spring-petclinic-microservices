package com.test.bank.branch.web;

import com.test.bank.branch.model.Address;
import com.test.bank.branch.model.Branch;
import com.test.bank.branch.model.EmpRepository;
import com.test.bank.branch.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(EmpController.class)
@ActiveProfiles("test")
public class EmpControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    EmpRepository empRepository;

    @Test
    void shouldGetEmpInJSonFormat() throws Exception {
        Employee employee = setupEmp();


        given(empRepository.findById(2)).willReturn(Optional.of(employee));
        mvc.perform(get("/emp/2").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(2))
            .andExpect(jsonPath("$.empNo").value("EMP1001"))
            .andExpect(jsonPath("$.empName").value("Rakesh Kumar"))
            .andExpect(jsonPath("$.age").value("25"))
            .andExpect(jsonPath("$.dob").value("2019-12-31"));

           //.andExpect(jsonPath("$.account[0].accountNo").value("SYN00102"))
            //.andExpect(jsonPath("$.account[0].type.id").value(6));
    }

    private Employee setupEmp() {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setEmpNo("EMP1001");//setFirstName("Rajesh");
        employee.setEmpName("Rakesh Kumar");
        employee.setAge("25");
        employee.setDob(LocalDate.of(2019,12,31));
        Address address = new Address();
        address.setAddress("RAJPURAM, CHIPIYANA");
        address.setId(2);
        address.setCity("New Delhi");
        address.setState("UP");
        address.setCountry("India");

        Branch branch = new Branch();
        branch.setName("Delhi");

        employee.setAddress(address);
        employee.setBranch(branch);
        return employee;
    }
}
