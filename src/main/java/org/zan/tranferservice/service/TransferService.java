package org.zan.tranferservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.zan.tranferservice.dto.TransferRequestDTO;
import org.zan.tranferservice.exception.SampleCrudException;
import org.zan.tranferservice.model.Transfer;

import java.util.List;
import java.util.Optional;
/**
 * This class provides the implementation of the TransferService interface.
 * It handles the creation of transfers, retrieval of transfer data, and finding transfers by ID.
 *
 * @author Muhammad Fauzan
 */
public interface TransferService {

    /**
     * Creates a new transfer based on the provided order ID.
     *
     * @param id The ID of the order used to create the transfer.
     * @return The created Transfer object.
     * @throws SampleCrudException if the order is not found or an unexpected error occurs.
     */
    Transfer create(Integer id) throws JsonProcessingException;

    /**
     * Retrieves all transfer data.
     *
     * @return A list of Transfer objects representing all transfer data.
     */
    List<Transfer> getAll();

    /**
     * Finds a transfer by its unique ID.
     *
     * @param id The unique ID of the transfer to find.
     * @return An Optional containing the found Transfer object, or an empty Optional if not found.
     * @throws SampleCrudException if the transfer is not found.
     */
    Optional<Transfer> findById(String id);

}
