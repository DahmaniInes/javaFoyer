package com.example.springproject.services;

import com.example.springproject.Entities.Etudiant;
import com.example.springproject.Entities.Reservation;
import com.example.springproject.Entities.Universite;
import com.example.springproject.repositiories.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService {

    ReservationRepository etud;

    @Override
    public Reservation addReservation(Reservation Reservation) {
        return etud.save(Reservation);
    }

    @Override
    public List<Reservation> listReservation() {
        return  etud.findAll();
    }

    @Override
    public Reservation getReservationById(String idReservation) {
        return  etud.findById(idReservation).get();
        //return chrep.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation Reservation) {
        return  etud.save(Reservation);
    }



    @Override
    public void deleteReservation(String idReservation) {
        etud.deleteById(idReservation);
    }



    @Override
    public Reservation ajouterReservationAvecEtudiants ( Reservation reservation){
    Reservation res=etud.save(reservation);
    List<Etudiant> e=  res.getEtudiants();
        reservation.setEtudiants(e);
        return  res;
    }

}
