package com.example.springproject.services;

import com.example.springproject.Entities.Reservation;
import com.example.springproject.Entities.Universite;

import java.util.List;

public interface IReservationService {
    public Reservation addReservation(Reservation reservation);
    public List<Reservation> listReservation();
    public  Reservation getReservationById(String idReservation);
    public Reservation updateReservation (Reservation reservation);

    public  void deleteReservation(String idReservation);

    public Reservation ajouterReservationAvecEtudiants ( Reservation reservation);

}
