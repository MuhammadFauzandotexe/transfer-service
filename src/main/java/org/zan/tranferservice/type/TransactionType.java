package org.zan.tranferservice.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * This enum represents transaction types used in the transfer service.
 * It defines two transaction types: REVERSAL and FINANCIAL.
 * Each transaction type has a corresponding string value.
 * The enum provides methods for deserializing from a string value (JsonCreator) and
 * serializing to a string value (JsonValue).
 */
public enum TransactionType {
    /**
     * Represents a REVERSAL transaction type.
     */
    REVERSAL("REVERSAL"),

    /**
     * Represents a FINANCIAL transaction type.
     */
    FINANCIAL("FINANCIAL");

    private final String value;

    /**
     * Constructor to set the string value for the enum constant.
     *
     * @param value The string value for the transaction type.
     */
    TransactionType(String value) {
        this.value = value;
    }

    /**
     * Deserialize a string value into a TransactionType enum constant.
     *
     * @param value The string value to deserialize.
     * @return The corresponding TransactionType enum constant.
     * @throws IllegalArgumentException if the input value is not a valid transaction type.
     */
    @JsonCreator
    public static TransactionType fromValue(String value) {
        for (TransactionType transactionType : values()) {
            if (transactionType.value.equals(value)) {
                return transactionType;
            }
        }
        throw new IllegalArgumentException("Invalid TransactionType value: " + value);
    }

    /**
     * Serialize a TransactionType enum constant to its string value.
     *
     * @return The string value representing the TransactionType.
     */
    @JsonValue
    public String getValue() {
        return value;
    }
}
