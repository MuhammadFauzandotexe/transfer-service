package org.zan.tranferservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.zan.tranferservice.configuration.AppProperties;
import org.zan.tranferservice.remote.client.SampleCrudClient;
import org.zan.tranferservice.remote.dto.ResponseDataDTO;
import org.zan.tranferservice.exception.SampleCrudException;
import org.zan.tranferservice.model.Transfer;
import org.zan.tranferservice.repository.TransferRepository;
import org.zan.tranferservice.service.TransferService;
import org.zan.tranferservice.util.RandomString;
import java.util.List;
import java.util.Optional;
/**
 * This class provides the implementation of the TransferService interface.
 * It handles the creation of transfers, retrieval of transfer data, and finding transfers by ID.
 *
 * @author Muhammad Fauzan
 */
@Service
@AllArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final SampleCrudClient sampleCrudClient;
    private final AppProperties appProperties;

    /**
     * {@inheritDoc}
     * @throws SampleCrudException
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public Transfer create(Integer id) {
        log.info("start get order with ID: " + id);
        try {
            ResponseDataDTO responseData = sampleCrudClient.getOrderById(id);
            ResponseDataDTO.Data data = responseData.getData();
            Transfer transfer = new Transfer();
            transfer.setReferenceId(RandomString.generateUniqueReferenceId());
            transfer.setAmount(data.getItems().stream().findFirst().get().getPrice() * data.getQuantity());
            transfer.setCompany(appProperties.getCompany());
            transfer.setOrderId(data.getId());
            Transfer transferSave = transferRepository.saveAndFlush(transfer);
            log.info("success create transfer with ID: " + transferSave.getId());
            return transferSave;
        } catch (SampleCrudException ex) {
            throw new SampleCrudException("Not Found order with ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new SampleCrudException("Not Found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Transfer> getAll() {
        log.info("start get all data transfer");
        List<Transfer> transfers = transferRepository.findAll();
        log.info("success get all data transfer");
        return transfers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Transfer> findById(String id) {
        log.info("start get transfer with ID: " + id);
        Optional<Transfer> transferOptional = transferRepository.findById(id);
        if (transferOptional.isEmpty()) {
            throw new SampleCrudException("transfer not with ID: " + id, HttpStatus.NOT_FOUND);
        }
        log.info("success get transfer with ID: " + id);
        return transferOptional;
    }
}

