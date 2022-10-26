package com.inventorymanager.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventorymanager.manager.entity.Item;
import com.inventorymanager.manager.entity.ItemEntity;
import com.inventorymanager.manager.entity.Location;
import com.inventorymanager.manager.repository.ItemEntityRepository;
import com.inventorymanager.manager.repository.ItemRepository;
import com.inventorymanager.manager.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerService {

    final ItemRepository itemRepository;
    final ItemEntityRepository itemEntityRepository;
    final LocationRepository locationRepository;

    public String hello(){
        return "Hello World";
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }
    public Optional<Item> getItemById(long id) {
        return itemRepository.findById(id);
    }
    public Item addItem(Item item){
        item.setItemEntities(null);
        return itemRepository.save(item);
    }

    public List<ItemEntity> getItemEntities(){
        return itemEntityRepository.findAll();
    }
    public Optional<ItemEntity> getItemEntityById(long id){
        return itemEntityRepository.findById(id);
    }
    public ItemEntity addItemEntity(ItemEntity itemEntity){
        Item item = itemRepository.findById(itemEntity.getItem().getId()).orElseThrow();
        Location location = locationRepository.findById(itemEntity.getLocation().getId()).orElseThrow();
        itemEntity.setItem(item);
        itemEntity.setLocation(location);
        return itemEntityRepository.save(itemEntity);
    }

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }
    public Optional<Location> getLocationById(long id){
        return locationRepository.findById(id);
    }
    public Location addLocation(Location location){
        location.setItemEntities(null);
        return locationRepository.save(location);
    }


    

}
