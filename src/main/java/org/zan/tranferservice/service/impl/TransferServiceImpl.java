package org.zan.tranferservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.zan.tranferservice.client.SampleCrudClient;
import org.zan.tranferservice.dto.ResponseDataDTO;
import org.zan.tranferservice.dto.TransactionType;
import org.zan.tranferservice.exception.SampleCrudException;
import org.zan.tranferservice.model.Order;
import org.zan.tranferservice.model.Transfer;
import org.zan.tranferservice.repository.OrderRepository;
import org.zan.tranferservice.repository.TransferRepository;
import org.zan.tranferservice.service.TransferService;
import org.zan.tranferservice.util.RandomString;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final SampleCrudClient sampleCrudClient;
    private final OrderRepository orderRepository;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Transfer create(Integer id) {
        log.info("start get order with ID: " + id);
        try {
            ResponseDataDTO responseData = sampleCrudClient.getOrderById(id);
            ResponseDataDTO.Data data = responseData.getData();
            Order order = new Order();
            order.setItem_id(data.getItems().stream().findFirst().get().getId());
            order.setItem_name(data.getItems().stream().findFirst().get().getName());
            order.setItem_price(data.getItems().stream().findFirst().get().getPrice());
            order.setQuantity(data.getQuantity());
            order.setOrderNo(data.getOrderNo());
            Order orderSave = orderRepository.saveAndFlush(order);
            Transfer transfer = new Transfer();
            transfer.setReferenceId(RandomString.generateUniqueReferenceId());
            transfer.setAmount(data.getItems().stream().findFirst().get().getPrice()*data.getQuantity());
            transfer.setTransactionType(TransactionType.FINANCIAL);
            transfer.setOrder(orderSave);
            Transfer transferSave = transferRepository.saveAndFlush(transfer);
            log.info("success create transfer with ID: "+id);
            return transferSave;
        } catch (SampleCrudException ex) {
            throw new SampleCrudException("Not Found order with ID: "+id,HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new SampleCrudException("Not Found: " + ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Transfer> getAll() {
        log.info("start get all data transfer");
        List<Transfer> transfers = transferRepository.findAll();
        log.info("success get all data transfer");
        return transfers;
    }

    @Override
    public Optional<Transfer> findById(Integer id) {
        log.info("start get transfer with ID: "+id);
        Optional<Transfer> transferOptional = transferRepository.findById(id);
        if (transferOptional.isEmpty()){
            throw new SampleCrudException("transfer not with ID: "+id, HttpStatus.NOT_FOUND);
        }
        log.info("success get transfer with ID: "+id);
        return transferOptional;
    }
}
