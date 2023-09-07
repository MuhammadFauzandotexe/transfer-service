package org.zan.tranferservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.zan.tranferservice.dto.TransactionType;

/**
 * Represents a financial transfer entity in the application.
 * This entity is used to record financial transactions and is associated with an {@link Order}.
 * It includes information such as the transaction amount, reference ID, transaction type, and associated order.
 *
 * @author :Muhammad Fauzan
 */
@Entity
@Table(name = "t_transfer")
@SequenceGenerator(name = "transfer_sequence", sequenceName = "transfer_sequence")
@Data
public class Transfer {
    /**
     * The unique identifier for the transfer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transfer_sequence")
    private Integer id;

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
     * The associated order for the transfer.
     */
    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonManagedReference
    private Order order;

    /**
     * Default constructor for the Transfer class.
     * Initializes the transaction type to {@link TransactionType#REVERSAL}.
     */
    public Transfer() {
        this.transactionType = TransactionType.REVERSAL;
    }
}
