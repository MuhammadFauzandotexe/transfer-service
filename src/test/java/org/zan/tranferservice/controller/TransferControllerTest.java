package org.zan.tranferservice.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zan.tranferservice.dto.CommonResponseDTO;
import org.zan.tranferservice.model.Transfer;
import org.zan.tranferservice.service.TransferService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransferControllerTest {

    @InjectMocks
    private TransferController transferController;

    @Mock
    private TransferService transferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransfer() throws JsonProcessingException {
        Integer orderId = 1;
        Transfer mockTransfer = new Transfer();
        when(transferService.create(orderId)).thenReturn(mockTransfer);
        ResponseEntity<CommonResponseDTO<Transfer>> response = transferController.transfer(orderId);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        CommonResponseDTO<Transfer> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(HttpStatus.CREATED.value(), responseBody.getStatusCode());
        assertEquals("success", responseBody.getMessage());
        assertEquals(mockTransfer, responseBody.getData());
    }

    @Test
    void testGetTransferById() {
        String transferId = "123";
        Transfer mockTransfer = new Transfer();
        when(transferService.findById(transferId)).thenReturn(Optional.of(mockTransfer));
        ResponseEntity<CommonResponseDTO<Optional<Transfer>>> response = transferController.getById(transferId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        CommonResponseDTO<Optional<Transfer>> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(HttpStatus.OK.value(), responseBody.getStatusCode());
        assertEquals("success", responseBody.getMessage());
        assertEquals(Optional.of(mockTransfer), responseBody.getData());
    }

    @Test
    void testGetAllTransfers() {
        List<Transfer> mockTransfers = Collections.singletonList(new Transfer());
        when(transferService.getAll()).thenReturn(mockTransfers);
        ResponseEntity<CommonResponseDTO<List<Transfer>>> response = transferController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        CommonResponseDTO<List<Transfer>> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(HttpStatus.OK.value(), responseBody.getStatusCode());
        assertEquals("success", responseBody.getMessage());
        assertEquals(mockTransfers, responseBody.getData());
    }
}
