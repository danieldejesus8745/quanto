package com.quanto.services;

import com.quanto.dto.ProductDTO;
import com.quanto.entities.Product;
import com.quanto.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setBrand(productDTO.getBrand());
        product.setLocal(productDTO.getLocal());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);
    }

}
