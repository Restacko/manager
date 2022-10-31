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
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    long groupId;
    Double price;
    String unit;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "item", fetch = FetchType.LAZY)
    //@JsonBackReference
    //@JoinColumn(name="itemId")
    List<ItemEntity> entities;

    @Override
    public String toString(){
        return "Item [id=" + this.id +", name=" + this.name + ", groupId=" + this.groupId + ", price=" + this.price + ", unit="+this.unit + ", entities=" + this.entities + "]";
    }
}
