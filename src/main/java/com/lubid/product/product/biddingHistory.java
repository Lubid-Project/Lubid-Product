package com.lubid.product.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor //기본생성자
@Entity
public class biddingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @Column
    private Long memberId;

    @Column
    private Long productId;

    @Column
    private int price;

    @Column(nullable = false)
    private LocalDateTime biddingAt = LocalDateTime.now();

}
