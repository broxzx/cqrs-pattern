package com.project.productreadservice.products.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    private String id;

    private String productName;

    private String productDescription;

}
