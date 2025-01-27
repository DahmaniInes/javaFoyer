package com.rendu.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMoniteur;
    private String numM;
    private String prenomM;
    private Date dateRecru;

    @OneToMany
    private List<Cours> Cours;

}
