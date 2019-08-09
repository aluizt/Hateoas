package br.com.estagio.hateoaspedidos.model.product;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private long productId;
    private String productName;
    private Double productPrice;
}
