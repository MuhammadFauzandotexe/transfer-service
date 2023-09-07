package org.zan.tranferservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zan.tranferservice.dto.CommonResponseDTO;
import org.zan.tranferservice.model.Transfer;
import org.zan.tranferservice.service.TransferService;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for managing transfer-related operations.
 * This class handles HTTP requests related to creating and retrieving transfers.
 *
 * @author Muhammad Fauzan
 */
@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
@Slf4j
public class TransferController {
    private final TransferService transferService;

    /**
     * Create a new transfer.
     * @param id               The ID of the order to which the transfer is related.
     * @return A ResponseEntity containing the created transfer.
     * @throws JsonProcessingException if there is an issue with JSON processing.
     */
    @PostMapping("/{id}")
    public ResponseEntity<CommonResponseDTO<Transfer>> transfer(@PathVariable Integer id) throws JsonProcessingException {
        Transfer transfer = transferService.create(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        CommonResponseDTO.<Transfer>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .message("success")
                                .data(transfer)
                                .build()
                );
    }

    /**
     * Get a transfer by its ID.
     *
     * @param id The ID of the transfer to retrieve.
     * @return A ResponseEntity containing the transfer, if found.
     */
    @GetMapping("{id}")
    public ResponseEntity<CommonResponseDTO<Optional<Transfer>>> getById(@PathVariable String id){
        Optional<Transfer> transfer = transferService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        CommonResponseDTO.<Optional<Transfer>>builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("success")
                                .data(transfer)
                                .build()
                );
    }

    /**
     * Get a list of all transfers.
     *
     * @return A ResponseEntity containing a list of all transfers.
     */
    @GetMapping
    public ResponseEntity<CommonResponseDTO<List<Transfer>>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(
                        CommonResponseDTO.<List<Transfer>>builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("success")
                                .data(transferService.getAll())
                                .build()
                );

    }
}
