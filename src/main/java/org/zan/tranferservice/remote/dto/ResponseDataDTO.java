package org.zan.tranferservice.remote.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/**
 * This class represents a response data transfer object (DTO) for remote service interactions.
 * It contains information such as the HTTP status code, a message, and a nested "Data" object.
 *
 * @author :Muhammad Fauzan
 */
@Setter
@Getter
public class ResponseDataDTO {
    /**
     * The HTTP status code of the response.
     */
    private int statusCode;

    /**
     * A message associated with the response.
     */
    private String message;

    /**
     * The nested "Data" object containing additional response data.
     */
    private Data data;

    /**
     * This class represents the nested "Data" object within the response DTO.
     */
    @Getter
    @Setter
    public static class Data {
        /**
         * The unique identifier for the data.
         */
        private Integer id;

        /**
         * The order number associated with the data.
         */
        private String orderNo;

        /**
         * The quantity of items in the data.
         */
        private Integer quantity;

        /**
         * A list of "Item" objects representing individual items within the data.
         */
        private List<Item> items;

        /**
         * This class represents an individual item within the "Data" object.
         */
        @Getter
        @Setter
        public static class Item {
            /**
             * The unique identifier for the item.
             */
            private Integer id;

            /**
             * The name of the item.
             */
            private String name;

            /**
             * The price of the item.
             */
            private Integer price;
        }
    }
}
