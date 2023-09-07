package org.zan.tranferservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    REVERSAL("REVERSAL"),
    FINANCIAL("FINANCIAL");
    private String value;

    TransactionType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TransactionType fromValue(String value) {
        for (TransactionType transactionType : values()) {
            if (transactionType.value.equals(value)) {
                return transactionType;
            }
        }
        throw new IllegalArgumentException("Invalid TransactionType value: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
