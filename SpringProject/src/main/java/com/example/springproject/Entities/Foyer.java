package com.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToMany (mappedBy = "foyer")
    private List<Bloc> blocs;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "foyer")
    private Universite universite;
}
