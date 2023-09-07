package org.zan.tranferservice.dto;

import lombok.Data;
import org.zan.tranferservice.type.TransactionType;

/**
 * This class represents a transfer request data transfer object (DTO).
 * It contains information about the transfer amount and the transaction type.
 *
 * @author :Muhammad Fauzan
 */
@Data
public class TransferRequestDTO {
    /**
     * The amount to be transferred.
     */
    private Integer amount;

    /**
     * The type of transaction (e.g., TRANSFER, REVERSAL).
     */
    private TransactionType transactionType;

    /**
     * Default constructor that sets the transaction type to REVERSAL.
     */
    public TransferRequestDTO() {
        transactionType = TransactionType.REVERSAL;
    }

    /**
     * Constructor to create a TransferRequestDTO with a specified transaction type.
     *
     * @param transactionType The type of transaction (e.g., TRANSFER, REVERSAL).
     */
    public TransferRequestDTO(TransactionType transactionType){
        this.transactionType = transactionType;
    }
}
