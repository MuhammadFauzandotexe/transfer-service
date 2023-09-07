package org.zan.tranferservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.zan.tranferservice.type.TransactionType;

/**
 * Represents a financial transfer entity in the application.
 * It includes information such as the transaction amount, reference ID, transaction type, and associated order.
 *
 * @author Muhammad Fauzan
 */
@Entity
@Table(name = "t_transfer")
@SequenceGenerator(name = "transfer_sequence", sequenceName = "transfer_sequence")
@Setter
@Getter
public class Transfer {
    /**
     * The unique identifier for the transfer.
     */
    @Id
    @GenericGenerator(strategy = "uuid2", name = "system-uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    /**
     * The amount of the financial transaction.
     */
    private Integer amount;

    /**
     * The reference ID associated with the transfer.
     */
    private String referenceId;

    /**
     * The type of transaction, which can be either {@link TransactionType#REVERSAL} or {@link TransactionType#FINANCIAL}.
     */
    private TransactionType transactionType;

    /**
     * The order ID associated with the transfer.
     */
    private Integer orderId;

    /**
     * The company associated with the transfer.
     */
    private String company;

    /**
     * Default constructor for the Transfer class.
     * Initializes the transaction type to {@link TransactionType#FINANCIAL}.
     */
    public Transfer() {
        this.transactionType = TransactionType.FINANCIAL;
    }
}
