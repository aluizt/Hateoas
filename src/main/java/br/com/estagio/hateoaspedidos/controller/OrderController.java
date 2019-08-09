package br.com.estagio.hateoaspedidos.controller;

import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.estagio.hateoaspedidos.model.order.*;
import br.com.estagio.hateoaspedidos.data.*;
import br.com.estagio.hateoaspedidos.response.*;
import br.com.estagio.hateoaspedidos.mapper.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final ItemResponseMapper mapperItem;
    private final OrderResponseMapper mapperOrder;

    public OrderController(ItemResponseMapper mapperItem, OrderResponseMapper mapperOrder) {
        this.mapperItem = mapperItem;
        this.mapperOrder = mapperOrder;
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderResponse> findOrder(@PathVariable("orderId")final Long orderId){
        return new ResponseEntity<>(
                new OrderResponse(DataOrder.getOrder(orderId),
                        mapperItem.toItemResponselist(
                                orderId,DataOrder.getOrder(orderId).getItemList())),HttpStatus.OK);
    }

    @GetMapping("/{ordeId}/item/{itemId}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable("ordeId")Long orderId,
                                                @PathVariable("itemId")Long itemId){

        return new ResponseEntity<>(
                new ItemResponse(orderId,DataOrder.getItem(orderId,itemId)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Resources<OrderResponse>> listAllOrder() {
        final Resources<OrderResponse> resources =
                new Resources<>(mapperOrder.toOrderResponseList(DataOrder.getOrderList()));

        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody Order order){
        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(order.getOrderId())
                        .toUri();

        var orderSave = DataOrder.saveOrder(order);
        return ResponseEntity.created(uri).body(new OrderResponse(orderSave,mapperItem.toItemResponselist(orderSave.getOrderId(),orderSave.getItemList())));

    }
}
