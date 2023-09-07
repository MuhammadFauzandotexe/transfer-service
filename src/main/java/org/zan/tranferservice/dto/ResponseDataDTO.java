package org.zan.tranferservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ResponseDataDTO {
    private int statusCode;
    private String message;
    private Data data;

    @Getter
    @Setter
    public static class Data {
        private Integer id;
        private String orderNo;
        private Integer quantity;
        private List<Item> items;

        @Getter
        @Setter
        public static class Item {
            private Integer id;
            private String name;
            private Integer price;
        }
    }
}
