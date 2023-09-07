package org.zan.tranferservice.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.zan.tranferservice.configuration.AppProperties;
import org.zan.tranferservice.exception.SampleCrudException;
import org.zan.tranferservice.model.Transfer;
import org.zan.tranferservice.remote.client.SampleCrudClient;
import org.zan.tranferservice.remote.dto.ResponseDataDTO;
import org.zan.tranferservice.repository.TransferRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransferServiceImplTest {

    @InjectMocks
    private TransferServiceImpl transferService;

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private SampleCrudClient sampleCrudClient;

    @Mock
    private AppProperties appProperties;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransferSuccess() {
        Integer orderId = 1;
        Transfer mockTransfer = new Transfer();
        when(sampleCrudClient.getOrderById(orderId)).thenReturn(createMockResponseDataDTO());
        when(transferRepository.saveAndFlush(any())).thenReturn(mockTransfer);
        Transfer createdTransfer = transferService.create(orderId);
        assertNotNull(createdTransfer);
        assertEquals(mockTransfer, createdTransfer);
    }

    @Test
    void testCreateTransferNotFound() {
        Integer orderId = 1;
        when(sampleCrudClient.getOrderById(orderId)).thenThrow(new SampleCrudException("Not Found", HttpStatus.NOT_FOUND));
        assertThrows(SampleCrudException.class, () -> {
            transferService.create(orderId);
        });
    }

    @Test
    void testGetAllTransfers() {
        List<Transfer> mockTransfers = Collections.singletonList(new Transfer());
        when(transferRepository.findAll()).thenReturn(mockTransfers);
        List<Transfer> transfers = transferService.getAll();
        assertNotNull(transfers);
        assertEquals(mockTransfers, transfers);
    }

    @Test
    void testFindTransferByIdSuccess() {
        String transferId = "123";
        Transfer mockTransfer = new Transfer();
        when(transferRepository.findById(transferId)).thenReturn(Optional.of(mockTransfer));
        Optional<Transfer> foundTransfer = transferService.findById(transferId);
        assertTrue(foundTransfer.isPresent());
        assertEquals(mockTransfer, foundTransfer.get());
    }

    @Test
    void testFindTransferByIdNotFound() {
        String transferId = "123";
        when(transferRepository.findById(transferId)).thenReturn(Optional.empty());
        assertThrows(SampleCrudException.class, () -> {
            transferService.findById(transferId);
        });
    }

    private ResponseDataDTO createMockResponseDataDTO() {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        ResponseDataDTO.Data data = new ResponseDataDTO.Data();
        data.setId(1);
        data.setOrderNo("ORDER123");
        data.setQuantity(2);
        List<ResponseDataDTO.Data.Item> items = new ArrayList<>();
        ResponseDataDTO.Data.Item item = new ResponseDataDTO.Data.Item();
        item.setId(1);
        item.setName("ItemName");
        item.setPrice(10);
        items.add(item);
        data.setItems(items);
        responseDataDTO.setData(data);
        return responseDataDTO;
    }
}
