package com.rendu.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;
    private Couleur couleur;
    private int longeur;
    private int pente;

    @ManyToMany(mappedBy = "P")
    private List<Skieur> S;
}
