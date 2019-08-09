package br.com.estagio.hateoaspedidos.mapper;

import org.springframework.stereotype.Component;
import br.com.estagio.hateoaspedidos.response.*;
import br.com.estagio.hateoaspedidos.model.item.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemResponseMapper {

   public ItemResponse toItemResponse(Long orderId,Item item){
       return new ItemResponse(orderId,item);
   }

    public List<ItemResponse> toItemResponselist(Long orderId,List<Item> itemlist){
         List<ItemResponse> itemResponseList = new ArrayList<>();
         itemlist.forEach(i-> {
             itemResponseList.add(new ItemResponse(orderId,i));
         });
         return itemResponseList;
    }
}
