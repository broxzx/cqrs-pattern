package com.project.productwriteservice.products.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.productwriteservice.enums.Action;
import com.project.productwriteservice.products.data.Product;
import com.project.productwriteservice.products.data.dto.ProductAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void createProduct(Product product) {
        productRepository.save(product);
        ProductAction productActionCreated = createProductActionCreated(product);
        try {
            kafkaTemplate.send("product-actions", objectMapper.writeValueAsString(productActionCreated));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    private ProductAction createProductActionCreated(Product product) {
        return new ProductAction(Action.CREATED, product);
    }

}
