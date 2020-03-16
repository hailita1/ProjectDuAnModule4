package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerHouseId implements Serializable {

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGiaoDich;

    @Column(name = "house_idNha")
    private Long idNha;

    @Column(name = "customer_idCustomer")
    private Long idCustomer;
}
