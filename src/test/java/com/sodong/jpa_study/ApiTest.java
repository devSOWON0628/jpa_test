package com.sodong.jpa_study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("test api (성공)")
    void childInsertApiTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/child"));

        resultActions.andExpect(status().isOk());
    }
}
