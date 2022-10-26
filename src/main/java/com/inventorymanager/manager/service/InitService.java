package com.inventorymanager.manager.service;

import java.util.ArrayList;
import java.util.List;

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
public class InitService {

    final ItemRepository itemRepository;
    final ItemEntityRepository itemEntityRepository;
    final LocationRepository locationRepository;
    
    public void populateDb(){
        List<Item> itemList = new ArrayList<>();
        List<ItemEntity> itemEntitiList = new ArrayList<>();
        List<Location> locationList = new ArrayList<>();

        for(int i = 1; i<=10;i++){
            itemList.add(new Item(i,"Item " + i, i, 20d * (1+i),"qty",null));
        }
        itemRepository.saveAll(itemList);
        for(int i = 1; i<=10;i++){
            for(int s = 1; s<=3; s++)
                for(int b = 1; b<=10; b++)
                    locationList.add(new Location(b + (s-1)*10 + (i-1)*30 , "A"+ i, (short)s, (short)b, null));
        }
        locationRepository.saveAll(locationList);
        for(int i = 1; i<=10;i++){
            itemEntitiList.add(new ItemEntity(i,2d,itemList.get(i-1),locationList.get(i+5)));
        }
        itemEntityRepository.saveAll(itemEntitiList);
    }
    
}

