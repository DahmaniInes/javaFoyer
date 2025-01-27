package com.example.springproject.services;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Chambre;
import com.example.springproject.repositiories.BlocRepository;
import com.example.springproject.repositiories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.Logger;
@Slf4j
@AllArgsConstructor
@Service

public class ChambreServiceImpl implements  IChambreService{

ChambreRepository chrep;
BlocRepository blocRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chrep.save(chambre);
    }

    @Override
    public List<Chambre> listChambre() {
        return chrep.findAll();
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        return chrep.findById(idChambre).get();
        //return chrep.findById(idChambre).orElse(null);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chrep.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
          chrep.deleteById(idChambre);
    }

    @Override
    public List<Chambre> addListChambre (List<Chambre> chs) {
        return chrep.saveAll(chs);
    }

    @Override
    public List<Chambre> chambresSelonNomBloc (String nom) {
        return chrep.findBybloc_NomBloc(nom);
    }
    @Override
    public List<Chambre> findByReservationAvecUnDateSpecifique(Date d1, Date d2) {
        return chrep.findByReservations_anneeUniversitaireBetween(d1 ,d2);
    }

    @Override
    public Integer nbChambreParCapaciteFoyerKeyword(Long c) {
        int s = chrep.countByBloc_foyer_CapaciteFoyerGreaterThan(c);
    return s;}

    @Override
    public Chambre affecterChambreABloc(Long num, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Chambre chambre = chrep.findByNumerochambre(num);
        chambre.setBloc(bloc);
        chrep.save(chambre);
        return chambre;
    }

    @Override
    public void desaffecterChambreDeBloc(Long num, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        Chambre chambre = chrep.findByNumerochambre(num);
        if(bloc != null){
            bloc.getChambres().remove(chambre);
            chrep.save(chambre);
        }}




  /*  @Scheduled(fixedDelay = 600)
    public void fixedDelayMethode(){
        log.info("Methode with fixed delay");
    }*/

   /* @Scheduled(fixedRate = 6000)
    public void fixedDelay(){
        log.info("Methode with fixed Rate");
    }*/

  /* @Scheduled(fixedDelay = 60000)
    public void scheduledchambre() {
        List<Bloc> blocs=blocRepository.findAll();
        log.info("Scheduled Job");
        for(Bloc bloc:blocs) {
            log.info("Bloc => " + bloc.getNomBloc() + " ayant un capicite " + bloc.getCapacitéBloc());
            log.info("La Liste des chambre pour ce bloc :");
            if (bloc.getChambres().isEmpty()) {
                log.info("pas de chambre");
            } else {
                for (Chambre chambre : bloc.getChambres()) {
                    log.info("numchambre : " + chambre.getNumerochambre() + " type : " + chambre.getTypeChambre());
                }
            }

        }}*/
}
