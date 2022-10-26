package com.inventorymanager.manager.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanager.manager.entity.Item;
import com.inventorymanager.manager.entity.ItemEntity;
import com.inventorymanager.manager.entity.Location;
import com.inventorymanager.manager.service.InitService;
import com.inventorymanager.manager.service.ManagerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final InitService initService;

    @GetMapping("/")
    public String hello() {
        return managerService.hello();
    }

    @GetMapping("/Init")
    public void init(){
        initService.populateDb();
    }

    @GetMapping("/items")
    public List<Item> getItems(){
        return managerService.getItems();
    }
    @GetMapping("/item/{id}")
    public Optional<Item> getItemById(@PathVariable long id){
        return managerService.getItemById(id);
    }
    @PostMapping("/item")
    public Item addItem(@RequestBody Item item){
        return managerService.addItem(item);
    }

    @GetMapping("/item_entities")
    public List<ItemEntity> getItemEntities(){
        return managerService.getItemEntities();
    }
    @GetMapping("/item_entity/{id}")
    public Optional<ItemEntity> getItemEntityById(@PathVariable long id){
        return managerService.getItemEntityById(id);
    }
    @PostMapping("/item_entity")
    public ItemEntity addItemEntity(@RequestBody ItemEntity itemEntity){
        return managerService.addItemEntity(itemEntity);
    }

    @GetMapping("/locations")
    public List<Location> getLocations(){
        return managerService.getLocations();
    }
    @GetMapping("/location/{id}")
    public Optional<Location> getLocationById(@PathVariable long id){
        return managerService.getLocationById(id);
    }
    @PostMapping("/location")
    public Location addLocation(@RequestBody Location location){
        return managerService.addLocation(location);
    }




}
