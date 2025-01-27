package com.example.springproject.services;

import com.example.springproject.Entities.Foyer;
import com.example.springproject.repositiories.BlocRepository;
import com.example.springproject.repositiories.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository etud;
    BlocRepository blocRepository;
    @Override
    public Foyer addFoyer(Foyer Foyer) {
        return etud.save(Foyer);
    }

    @Override
    public List<Foyer> listFoyer() {
        return  etud.findAll();
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        return  etud.findById(idFoyer).get();
        //return chrep.findById(idFoyer).orElse(null);
    }

    @Override
    public Foyer updateFoyer(Foyer Foyer) {
        return  etud.save(Foyer);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        etud.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerAvecBlocsAssociés(Foyer foyer) {
        Foyer   f=etud.save(foyer);
        f.getBlocs().forEach( bloc ->
                {
                    bloc.setFoyer(f);
                    blocRepository.save(bloc);
                }
        );
        return f;
    }
}
