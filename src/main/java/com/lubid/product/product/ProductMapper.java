package com.lubid.product.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "memberId", ignore = true)
    Product productPostDtoToProduct(ProductDto.Post productPostDto);

    @Mapping(target = "memberId", ignore = true)
    Product productPatchDtoToProduct(ProductDto.Patch productPatchDto);
    ProductDto.Response productToProductResponseDto(Product product);
    List<ProductDto.Response> productsToProductResponseDtos(List<Product> products);
}
