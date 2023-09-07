package org.zan.tranferservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.zan.tranferservice.dto.TransferRequestDTO;
import org.zan.tranferservice.model.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferService {
    Transfer create(Integer id) throws JsonProcessingException;
    List<Transfer> getAll();
    Optional<Transfer> findById(Integer id);

}
