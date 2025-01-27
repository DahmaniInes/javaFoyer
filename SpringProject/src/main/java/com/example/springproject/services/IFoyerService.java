package com.example.springproject.services;

import com.example.springproject.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public List<Foyer> listFoyer();
    public  Foyer getFoyerById(Long idFoyer);
    public Foyer updateFoyer (Foyer foyer);

    public  void deleteFoyer(Long idFoyer);

    public Foyer ajouterFoyerAvecBlocsAssociés (Foyer foyer);
}
