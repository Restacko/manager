package com.inventorymanager.manager.entity.dto;

import lombok.Data;

@Data
public class ItemEntityDto {
    long id;
    long itemId;
    long locationId;
    double quantity;
}
