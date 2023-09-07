package org.zan.tranferservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import jakarta.persistence.*;

/**
 * Represents an order entity in the application.
 * An order contains information such as the order number, quantity, and details of the ordered items.
 * It is associated with a {@link Transfer} entity, representing a financial transfer related to the order.
 * @author :Muhammad Fauzan
 */
@Entity
@Table(name = "t_order")
@SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence")
@Data
public class Order {
    /**
     * The unique identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Integer id;

    /**
     * The order number, a unique identifier for the order.
     */
    private String orderNo;

    /**
     * The quantity of items included in the order.
     */
    private Integer quantity;

    /**
     * The ID of the ordered item.
     */
    private Integer item_id;

    /**
     * The name of the ordered item.
     */
    private String item_name;

    /**
     * The price of the ordered item.
     */
    private Integer item_price;

    /**
     * The associated transfer for the order.
     * Represents a financial transaction related to the order.
     */
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonBackReference
    private Transfer transfer;

}
