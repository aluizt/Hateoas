package br.com.estagio.hateoaspedidos.mapper;

import org.springframework.stereotype.Component;
import br.com.estagio.hateoaspedidos.response.*;
import br.com.estagio.hateoaspedidos.model.order.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderResponseMapper {


    private final ItemResponseMapper mapper;

    public OrderResponseMapper(ItemResponseMapper mapper) {
        this.mapper = mapper;
    }

    public List<OrderResponse> toOrderResponseList(List<Order> orderList){
        List<OrderResponse> orderResponseList = new ArrayList<>();
        orderList.forEach(order -> {
            orderResponseList.add(toOrderResponse(order));
        });

        return orderResponseList;
    }

    public OrderResponse toOrderResponse(Order order){
        return new  OrderResponse(order,mapper.toItemResponselist(order.getOrderId(),order.getItemList()));
    }
}
