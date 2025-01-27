package com.example.springproject.services;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Chambre;
import com.example.springproject.Entities.Foyer;
import com.example.springproject.repositiories.BlocRepository;
import com.example.springproject.repositiories.ChambreRepository;
import com.example.springproject.repositiories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.List;
@Aspect
@AllArgsConstructor
@Service
public class BlocServiceImpl implements IBlocService{
    BlocRepository chrep;
    FoyerRepository foyerRepository;
    ChambreRepository chambreRepository;
    @Override
    public Bloc addBloc(Bloc Bloc) {
        return chrep.save(Bloc);
    }

    @Override
    public List<Bloc> listBloc() {
        return chrep.findAll();
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        return chrep.findById(idBloc).get();
        //return chrep.findById(idBloc).orElse(null);
    }

    @Override
    public Bloc updateBloc(Bloc Bloc) {
        return chrep.save(Bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        chrep.deleteById(idBloc);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) {
        Bloc bloc= chrep.findByNomBloc(nomBloc);
        Foyer f=foyerRepository.save(foyer);
        bloc.setFoyer(f);
        chrep.save(bloc);
        return bloc;
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        Bloc bloc = chrep.findById(idBloc).get();
       List<Chambre> list=chambreRepository.findByNumerochambreIn(numChambre);
       list.forEach(chambre -> {
           chambre.setBloc(bloc);
           chambreRepository.save(chambre);
    });
 return bloc;

}}
