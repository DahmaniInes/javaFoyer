package com.example.springproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.springproject.Entities.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long numerochambre;
    @Enumerated(value = EnumType.STRING)
    private TypeChambre TypeChambre;

    @OneToMany
    private List<Reservation> reservations;

    @ManyToOne
    @JsonIgnoreProperties("chambres")

    private Bloc bloc;
}
