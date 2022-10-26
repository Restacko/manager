package com.inventorymanager.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanager.manager.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    
}
