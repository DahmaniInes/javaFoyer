package com.example.springproject.services;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Foyer;

import java.util.List;

public interface IBlocService {

    public Bloc addBloc(Bloc Bloc);
    public List<Bloc> listBloc();
    public  Bloc getBlocById(Long idBloc);
    public Bloc updateBloc (Bloc Bloc);

    public  void deleteBloc(Long idBloc);
    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) ;

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
