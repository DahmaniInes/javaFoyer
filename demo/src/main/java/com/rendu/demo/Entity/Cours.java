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
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private int niveau;
    @Enumerated(value = EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(value = EnumType.STRING)
    private Support support;
    private  Float prix;
    private int creneau;

    @OneToMany(mappedBy = "C")
    private List<Inscription> I;

}
