package br.com.estagio.hateoaspedidos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;
import br.com.estagio.hateoaspedidos.model.order.*;
import br.com.estagio.hateoaspedidos.controller.*;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
@Setter
public class OrderResponse extends ResourceSupport {

    private final Long orderId;
    private final List<ItemResponse> itemResponseList;

    public OrderResponse(Order order, List<ItemResponse> itemResponseList) {
        this.orderId = order.getOrderId();
        this.itemResponseList = itemResponseList;

        add(linkTo(OrderController.class).withRel("Order List"));
        add(linkTo(methodOn(OrderController.class).findOrder(orderId)).withSelfRel());

    }
}
