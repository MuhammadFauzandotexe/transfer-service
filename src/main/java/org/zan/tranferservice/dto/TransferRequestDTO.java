package org.zan.tranferservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransferRequestDTO {
    private Integer amount;
    @JsonProperty("transaction_type")
    private TransactionType transactionType;

    public TransferRequestDTO() {
        transactionType = TransactionType.REVERSAL;
    }
    public TransferRequestDTO(TransactionType transactionType){
        this.transactionType = transactionType;
    }
}
