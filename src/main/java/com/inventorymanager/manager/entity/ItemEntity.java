package com.inventorymanager.manager.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //long itemId;
    //long locationId;
    double quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="itemId")
    //@JsonManagedReference
    Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="locationId")
    Location location;

    @Override
    public String toString(){
        return "ItemEntity [id=" + this.id + ", quantity=" + this.quantity + "]";
    }
}
