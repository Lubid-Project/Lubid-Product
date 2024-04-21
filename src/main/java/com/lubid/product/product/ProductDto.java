package com.lubid.product.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class ProductDto {
    /*
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuctionPost{

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LivePost{

    }
    @Getter
    public static class AuctionPatch {
        private Long productId;


        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }

    @Getter
    public static class LivePatch {
        private Long productId;


        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post{
        private String productCategory;
        private String saleType;
        private String productBrand;
        @NotBlank(message = "제목을 입력해주세요.")
        private String productTitle;
        @NotBlank(message = "내용을 입력해주세요.")
        private String productContent;
        private int minPrice;
        private String productImageLink;
    }

    @Getter
    public static class Patch{
        private Long productId;

        private String productCategory;
        private String saleType;
        private String productBrand;
        private String productTitle;
        private String productContent;
        private int minPrice;
        private String productImageLink;

        public void setProductId(Long productId) {this.productId = productId;}

    }

    @NoArgsConstructor
    @Setter
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long productId;

        private String productCategory;
        private String saleType;
        private String productBrand;
        private String productTitle;
        private String productContent;
        private Product.ProductStatus productStatus;
        //private Long memberId;
        private int minPrice;
        private int soldPrice;
        private String productImageLink;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Like {
        private long productId;
    }

    @NoArgsConstructor
    @Setter
    @Getter
    @AllArgsConstructor
    public static class LikeResponse {
        private Long likeId;
        private Long productId;
        private Long memberId;
        private boolean status;

    }
}
