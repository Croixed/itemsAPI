package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);

    void delete( int itemId );

    List<Item> all();

    Item findById(int itemId );
}
