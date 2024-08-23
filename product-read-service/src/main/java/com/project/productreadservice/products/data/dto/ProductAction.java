package com.project.productreadservice.products.data.dto;

import com.project.productreadservice.model.Action;
import com.project.productreadservice.products.data.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductAction {

    private Action action;

    private Product product;

}
