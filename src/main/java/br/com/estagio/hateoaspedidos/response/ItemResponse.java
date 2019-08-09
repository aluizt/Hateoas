package br.com.estagio.hateoaspedidos.response;

import br.com.estagio.hateoaspedidos.controller.OrderController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import br.com.estagio.hateoaspedidos.model.item.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
@Setter
public class ItemResponse extends ResourceSupport {

    private final Item item;

    public ItemResponse(Long orderId,Item item) {
        this.item = item;
        Long itemId= item.getItemId();
        add(linkTo(methodOn(OrderController.class).findOrder(orderId)).withRel("Order"));
        add(linkTo(methodOn(OrderController.class).getItem(orderId,itemId)).withSelfRel());
    }
}
