package com.example.itemsAPI.Controller;

import com.example.itemsAPI.Controller.dto.ItemDto;
import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController{

    final ItemService itemService;


    public ItemController(@Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public Iterable<Item> getItems(){
        return itemService.all();
    }

    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id){
        return itemService.findById(id).get();
        // might not need get()?
    }

    @PostMapping
    public Item save(@RequestBody ItemDto itemDto){
        return itemService.save(new Item(itemDto));
    }

}