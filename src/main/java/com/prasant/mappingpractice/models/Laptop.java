package com.prasant.mappingpractice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    private String id;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;
}
