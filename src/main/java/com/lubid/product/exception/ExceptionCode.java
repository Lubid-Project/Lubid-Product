package com.lubid.product.exception;

import lombok.Getter;

public enum ExceptionCode {
    PRODUCT_NOT_FOUND(404, "Product not found"),
    PRODUCT_EXISTS(409, "Product exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
