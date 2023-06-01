package ru.neoflex.practice.MockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CaclControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCalculatePlus() throws Exception {
        this.mockMvc.perform(get("/plus/10/9"))
                .andDo(print())
                .andExpect(content().string("19"));
    }

    @Test
    public void shouldCalculateMinus() throws Exception {
        this.mockMvc.perform(get("/minus/10/9"))
                .andDo(print())
                .andExpect(content().string("1"));
    }
}
