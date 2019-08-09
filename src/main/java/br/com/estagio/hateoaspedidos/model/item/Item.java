package br.com.estagio.hateoaspedidos.model.item;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private Long itemId;
    private String itemDesc;
    private int itemAmount;
    private Double itemPrice;
}
