package com.example.springproject.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

}
