package br.com.estagio.hateoaspedidos.model.order;

import lombok.*;
import br.com.estagio.hateoaspedidos.model.item.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private List<Item> itemList;
}
