package com.inventorymanager.manager.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventorymanager.manager.entity.Item;
import com.inventorymanager.manager.entity.ItemEntity;
import com.inventorymanager.manager.entity.Location;
import com.inventorymanager.manager.entity.dto.ItemEntityDto;
import com.inventorymanager.manager.service.InitService;
import com.inventorymanager.manager.service.ManagerService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final InitService initService;

    @GetMapping("/")
    public String hello() {
        return "item_list";
    }

    @ModelAttribute("items")
    public List<Item> popuItems(){
        return managerService.getItems();
    }
    @ModelAttribute("entities")
    public List<ItemEntity> popuItemEntities(){
        return managerService.getItemEntities();
    }
    @ModelAttribute("locations")
    public List<Location> popuLocations(){
        return managerService.getLocations();
    }
    @GetMapping("/add_item")
    public String openAddItemPage(Model model){
        model.addAttribute("item", new Item());
        return "add_item";
    }
    @GetMapping("/add_location")
    public String openAddLocationPage(Model model){
        model.addAttribute("location", new Location());
        return "add_location";
    }
    @GetMapping("/add_item_entity")
    public String openAddItemEntityPage(Model model){
        model.addAttribute("item_entity", new ItemEntityDto());
        return "add_item_entity";
    }

    

    @PostMapping("/Init")
    public String init(){
        initService.populateDb();
        return "redirect:/";
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
    public String addItem(Item item){
        managerService.addItem(item);
        return "redirect:/";
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
    public String addItemEntityDto(ItemEntityDto itemEntityDto){
        System.out.print("\n\n itemId= " + itemEntityDto.getItemId() +" locationId= " + itemEntityDto.getLocationId() + "\n\n");
        managerService.addItemEntity(itemEntityDto);
        return "redirect:/";
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
    public String addLocation(Location location){
        managerService.addLocation(location);
        return "redirect:/";
    }




}
