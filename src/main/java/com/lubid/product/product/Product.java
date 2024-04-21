package com.lubid.product.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    //옷, 가방, 악세서리, 신발
    @Column
    private String productCategory;

    //auction, live
    @Column
    private String saleType;

    @Column
    private String productBrand;

    @Column
    private String productTitle;

    @Column
    private String productContent;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ProductStatus productStatus = ProductStatus.PRODUCT_SELLING;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @Column
    private LocalDateTime closedAt;

    @Column
    private Long memberId;

    @Column
    private int minPrice;

    @Column
    private int soldPrice;

    @Column
    private String productImageLink;

    public enum ProductStatus {
        PRODUCT_SOLD("판매된 제품"),
        PRODUCT_SELLING("판매중인 제품"),
        PRODUCT_FINISH("마감된 제품"),

        PRODUCT_DELETE("삭제된 제품");

        @Getter
        private String status;

        ProductStatus(String status) {
            this.status = status;
        }
    }


}
