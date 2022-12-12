package com.examb.examb.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String designation;

    private  String adresse ;

    private int capacite ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parking")

    private Set<Zone> zones ;

}
