package com.example.springproject.services;

import com.example.springproject.Entities.Chambre;

import java.util.Date;
import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public List<Chambre> listChambre();
    public  Chambre getChambreById(Long idChambre);
    public Chambre updateChambre (Chambre chambre);

    public  void deleteChambre(Long idChambre);
    List<Chambre> addListChambre (List<Chambre> chs);
    List<Chambre> chambresSelonNomBloc (String nom);
    List<Chambre> findByReservationAvecUnDateSpecifique(Date d1 , Date d2);
    Integer nbChambreParCapaciteFoyerKeyword(Long c);
    public Chambre affecterChambreABloc (Long num, Long idBloc);
    public void desaffecterChambreDeBloc (Long num, Long idBloc);

}
