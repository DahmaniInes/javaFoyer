package com.rendu.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Abonnement {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long numAbon;
   private Date dateDebut;
   private Date dateFin;
   private Float prixAbon;
   private TypeAbonnement TypeAbon;
}
