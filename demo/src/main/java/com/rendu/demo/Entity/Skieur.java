package com.rendu.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private Date dateNaissance;
    private String ville;

    @ManyToMany
    private List<Piste> P;

    @OneToMany(mappedBy = "S")
    private List<Inscription> I;

    @OneToOne
    private Abonnement A;
}
