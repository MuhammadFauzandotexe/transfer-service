package org.zan.tranferservice.remote.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) representing a response data structure.
 * This class is used to encapsulate response data sent from the remote service.
 *
 * @author :Muhammad Fauzan
 */
@Setter
@Getter
public class ResponseDataDTO {
    private String statusCode;
    private String message;
    private Data data;

    /**
     * Nested DTO class representing the data part of the response.
     */
    @Setter
    @Getter
    public static class Data {
        private UUID id;
        private String orderNo;
        private List<OrderDetail> orderDetails;

        /**
         * Nested DTO class representing order details.
         */
        @Setter
        @Getter
        public static class OrderDetail {
            private UUID id;
            private Integer quantity;
            private List<Item> items;

            /**
             * Nested DTO class representing items within an order detail.
             */
            @Setter
            @Getter
            public static class Item {
                private UUID id;
                private String name;
                private Integer price;
            }
        }
    }
}
