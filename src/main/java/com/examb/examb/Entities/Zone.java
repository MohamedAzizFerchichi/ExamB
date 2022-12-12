package com.examb.examb.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String ref;

    private float dimension ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Personnel>  personnels ;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "zone")
    private Personnel personnel ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Parking parking ;





}
