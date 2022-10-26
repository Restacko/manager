package com.inventorymanager.manager.entity.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    long id;
    String title;
    String content;
    LocalDateTime created;
}
