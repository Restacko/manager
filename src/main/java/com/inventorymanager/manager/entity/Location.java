package com.inventorymanager.manager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property =  "id")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String rack;
    short shelf;
    short bin;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "location", fetch = FetchType.LAZY)
    List<ItemEntity> entities;
    
}
