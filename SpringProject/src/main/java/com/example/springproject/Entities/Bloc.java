package com.example.springproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capacitéBloc;
    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    @JsonIgnoreProperties("bloc")
    private List<Chambre> chambres;

}
