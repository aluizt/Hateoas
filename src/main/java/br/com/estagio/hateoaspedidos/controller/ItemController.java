package br.com.estagio.hateoaspedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estagio.hateoaspedidos.model.item.*;
@RestController
@RequestMapping("/iten")
public class ItemController {

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("itemId") Long itemId){
        return null;
    }
}
