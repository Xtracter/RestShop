package com.crazedout.restshop.controller;

import com.crazedout.restshop.model.ShopModel;
import com.crazedout.restshop.service.RESTService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("unused")
@WebMvcTest(RESTController.class)
class RESTControllerTest {

    @MockitoBean
    private RESTService service;

    @Autowired
    private ObjectMapper objMapper;

    @Autowired
    private MockMvc mock;

    @Test
    void listRestShops() throws Exception {
        Mockito.when(service.findAll()).thenReturn(List.of(new ShopModel("A", "B")));
        mock.perform(get("/api/restshop"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("A"));
    }

    @Test
    void createRestShop() throws Exception {
        ShopModel t = new ShopModel("New", "desc");
        ShopModel saved = new ShopModel("New", "desc");
        saved.setId(1L);

        Mockito.when(service.save(any(ShopModel.class))).thenReturn(saved);

        mock.perform(post("/api/restshop")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objMapper.writeValueAsString(t)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/restshop/1"))
                .andExpect(jsonPath("$.id").value(1));
    }
}
