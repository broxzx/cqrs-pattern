package com.project.productwriteservice.products.data.dto;

import com.project.productwriteservice.enums.Action;
import com.project.productwriteservice.products.data.Product;
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
