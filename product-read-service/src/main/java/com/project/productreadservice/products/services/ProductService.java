package com.project.productreadservice.products.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.productreadservice.products.data.Product;
import com.project.productreadservice.products.data.dto.ProductAction;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @SneakyThrows
    @KafkaListener(topics = "product-actions", groupId = "product-read-service")
    public void listen(String mappedProductAction) {
        ProductAction productAction = objectMapper.readValue(mappedProductAction, ProductAction.class);

        switch (productAction.getAction()) {
            case CREATED -> {
                productRepository.save(productAction.getProduct());
            }
            default -> {
                log.info(productAction.getAction().toString());
            }
        }
    }

}
