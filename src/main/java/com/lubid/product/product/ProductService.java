package com.lubid.product.product;

import com.lubid.product.exception.BusinessLogicException;
import com.lubid.product.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product){

        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        Product findProduct = findVerifiedProduct(product.getProductId());

        Optional.ofNullable(product.getProductCategory())
                .ifPresent(productCategory -> findProduct.setProductCategory(productCategory));
        Optional.ofNullable(product.getSaleType())
                .ifPresent(saleType -> findProduct.setSaleType(saleType));
        Optional.ofNullable(product.getProductBrand())
                .ifPresent(productBrand -> findProduct.setProductBrand(productBrand));
        Optional.ofNullable(product.getProductTitle())
                .ifPresent(productTitle -> findProduct.setProductTitle(productTitle));
        Optional.ofNullable(product.getProductContent())
                .ifPresent(productContent -> findProduct.setProductContent(productContent));
        Optional.ofNullable(product.getMinPrice())
                .ifPresent(minPrice -> findProduct.setMinPrice(minPrice));
        Optional.ofNullable(product.getProductImageLink())
                .ifPresent(productImageLink -> findProduct.setProductImageLink(productImageLink));

        return productRepository.save(findProduct);
    }

    public Product findProduct(Long productId) {
        Product product = findVerifiedProduct(productId);
        return product;
    }

    public Page<Product> findProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size,
                Sort.by("createdAt").descending()));
    }

    public List<Product> findProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public void deleteProduct(long productId) {
        Product findProduct = findVerifiedProduct(productId);

        productRepository.delete(findProduct);
    }

    public Product findVerifiedProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findByProductId(productId);
        Product findProduct =
                optionalProduct.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.PRODUCT_NOT_FOUND));

        return findProduct;
    }
}
