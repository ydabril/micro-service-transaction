package com.emazon.mstransaction.adapters;

import com.emazon.mstransaction.adapters.driving.http.controller.SupplyRestController;
import com.emazon.mstransaction.adapters.driving.http.dto.request.AddSuppliesRequest;
import com.emazon.mstransaction.adapters.driving.http.mapper.ISupplyRequestMapper;
import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.infraestructure.configuration.jwt.JwtAuthenticationFilter;
import com.emazon.mstransaction.infraestructure.configuration.jwt.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SupplyRestController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class SupplyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISupplyServicePort supplyServicePort;

    @MockBean
    private ISupplyRequestMapper supplyRequestMapper;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveSupplyTest() throws Exception {
        AddSuppliesRequest suppliesRequest = new AddSuppliesRequest(1L, 10L);

        Supply supply = new Supply(1L, 10L, null, null);

        when(supplyRequestMapper.addSupplyRequest(any(AddSuppliesRequest.class))).thenReturn(supply);
        doNothing().when(supplyServicePort).addSupplies(any(Supply.class));

        mockMvc.perform(post("/transaction/add-supplies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(suppliesRequest))
        ).andExpect(status().isCreated());

        verify(supplyRequestMapper).addSupplyRequest(any(AddSuppliesRequest.class));
        verify(supplyServicePort).addSupplies(any(Supply.class));
    }
}
