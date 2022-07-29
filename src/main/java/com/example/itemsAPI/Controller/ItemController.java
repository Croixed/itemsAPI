package com.example.itemsAPI.Controller;

import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController{

    final ItemService itemService;


    public ItemController(@Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> getItems(){
        return itemService.all();
    }
}