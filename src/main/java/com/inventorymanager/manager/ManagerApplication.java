package com.inventorymanager.manager;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inventorymanager.manager.entity.Item;
import com.inventorymanager.manager.entity.ItemEntity;
import com.inventorymanager.manager.entity.Location;
import com.inventorymanager.manager.repository.ItemEntityRepository;
import com.inventorymanager.manager.repository.ItemRepository;
import com.inventorymanager.manager.repository.LocationRepository;


@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner mapping(ItemRepository itemRepository, ItemEntityRepository itemEntityRepository,LocationRepository locationRepository){
		return args -> {

			Item item = new Item(1,"Hammer",1,2d,"Qty",null);
			Location location = new Location(1, "A", (short) 1, (short) 2, null);
			ItemEntity entity = new ItemEntity(1,2d,item,location);
			List<ItemEntity> entList = new ArrayList<>();
			entList.add(entity);
			item.setEntities(entList);
			location.setEntities(entList);
			locationRepository.save(location);
			itemRepository.save(item);
			itemEntityRepository.save(entity);
			System.out.print("\n\n\n\n" + item.getEntities().get(0).toString() + "\n\n\n");
		};
	}

}
