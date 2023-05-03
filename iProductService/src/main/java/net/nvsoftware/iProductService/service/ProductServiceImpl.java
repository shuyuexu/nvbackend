package net.nvsoftware.iProductService.service;

import net.nvsoftware.iProductService.Entity.ProductEntity;
import net.nvsoftware.iProductService.model.ProductRequest;
import net.nvsoftware.iProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Override
    public Long createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = ProductEntity.builder()
                .productName(productRequest.getProductName())
                .productPrice(productRequest.getProductPrice())
                .productQuantity(productRequest.getProductQuantity())
                .build();
        productRepository.save(productEntity);
        return productEntity.getProductId();
    }
}
