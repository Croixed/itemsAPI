package com.example.itemsAPI.Controller;

import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController{

    final ItemRepository itemRepository;


    public ItemController(@Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public Iterable<Item> getItems(){
        return itemRepository.findAll();
    }
}