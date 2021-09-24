package io.moon.front.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String prefixURI = "/products";

    @Test
    @DisplayName("상품 상세 조회 테스트")
    public void getDetail() throws Exception {

        // Given
        Long id = 1L;
        String requestURI = String.format("%s/{id}", prefixURI);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        // when & then
        mockMvc.perform(get(requestURI, id).params(params))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
