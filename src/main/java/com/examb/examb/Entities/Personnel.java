package com.examb.examb.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom ;
    private int age ;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement ;
    private String login ;
    private String password ;
    @Enumerated(EnumType.STRING)
    private Poste poste ;

    @OneToOne(cascade = CascadeType.ALL)
    private Zone zone ;

      /*
    when dealing with LocalDate, @Temporal annotation is not needed.
    It was needed for java.util.Date
    //@Temporal(TemporalType.DATE)
    private java.util.Date dateDebutContrat;
    */

}

