package com.lubid.product.product;

import com.lubid.product.response.MultiResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@Validated
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper){
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity postProduct(@Valid @RequestBody ProductDto.Post productDto) {
        Product product = productService.createProduct(productMapper.productPostDtoToProduct(productDto));

        return ResponseEntity.ok(productMapper.productToProductResponseDto(product));
    }

    @PatchMapping("/{product-id}")
    public ResponseEntity patchProduct(@PathVariable("product-id") @Positive long productId,
                                     @Valid @RequestBody ProductDto.Patch productDto) {

        productDto.setProductId(productId);
        Product product = productService.updateProduct(productMapper.productPatchDtoToProduct(productDto));

        return ResponseEntity.ok(productMapper.productToProductResponseDto(product));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity getProduct(@PathVariable("product-id") Long productId) {
        Product product = productService.findProduct(productId);
        return new ResponseEntity<>(productMapper.productToProductResponseDto(product), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable(value = "productId") Long productId) {
        productService.deleteProduct(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //게시물 전체 조회
    @GetMapping
    public ResponseEntity getProducts(@RequestParam(value = "page") int page,
                                    @RequestParam(value = "size") int size) {
        Page<Product> pageBoards = productService.findProducts(page - 1, size);
        List<Product> productList = pageBoards.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(productMapper.productsToProductResponseDtos(productList), pageBoards), HttpStatus.OK);
    }
}
