package com.example.springproject.services;

import com.example.springproject.Entities.Universite;

import java.util.List;

public interface IUniversiteService {

    public Universite addUniversite(Universite Universite);
    public List<Universite> listUniversite();
    public  Universite getUniversiteById(Long idUniversite);
    public Universite updateUniversite (Universite Universite);

    public  void deleteUniversite(Long idUniversite);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
