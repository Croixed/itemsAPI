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
        return itemService.findById(id);
    }

    @PostMapping
    public Item save(@RequestBody ItemDto itemDto) {
        return itemService.save(new Item(itemDto));
    }

    @PutMapping( "/{id}" )
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id ) {
        Item item = itemService.findById(id);
        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item.setImageUrl(itemDto.getImageUrl());
        return itemService.save(item);
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id ) {
        itemService.delete( id );
    }

}