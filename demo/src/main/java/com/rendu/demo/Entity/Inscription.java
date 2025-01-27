package com.rendu.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;
    private int numSemaine;

    @ManyToOne
    private Skieur S;

    @ManyToOne
    private Cours C;

}
