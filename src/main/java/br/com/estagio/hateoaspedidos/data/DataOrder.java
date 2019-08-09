package br.com.estagio.hateoaspedidos.data;

import br.com.estagio.hateoaspedidos.model.order.*;
import br.com.estagio.hateoaspedidos.model.item.*;
import br.com.estagio.hateoaspedidos.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataOrder {

    private static List<Order> orderList = new ArrayList<>();

    public static List<Order> getOrderList(){
        return orderList;
    }

    public static Order saveOrder(Order order){
        DataOrder.findtOrder(order.getOrderId());
        orderList.add(order);
        return order;
    }

    public static Order getOrder(Long orderId){
        List<Order> order = new ArrayList<>();
        orderList.forEach(o-> {
            if(o.getOrderId().equals(orderId)){
                order.add(o);

            }});
        if(order.isEmpty()) throw new OrderNotFoundExceptiom("Order "+orderId+" not found!");
        return order.get(0);
    }

    public static Item getItem(Long orderId, Long itemId){
        List<Item> itemList = new ArrayList<>();
        orderList.forEach(o-> {
            if(o.getOrderId().equals(orderId)){
                var items = o.getItemList();
                items.forEach(item -> {
                    if(item.getItemId().equals(itemId)){
                        itemList.add(item);
                    }
                });

            }});
        if(itemList.isEmpty()) throw new ItemNotFoundExceptiom("Item "+itemId+" not found!");
        return itemList.get(0);
    }

    public static void findtOrder(Long orderId){
        List<Order> order = new ArrayList<>();
        orderList.forEach(o-> {
            if(o.getOrderId().equals(orderId)){
                order.add(o);

            }});
        if(!order.isEmpty()) throw new OrderFoundExceptiom("Order "+orderId+" already exists!");

    }

}
