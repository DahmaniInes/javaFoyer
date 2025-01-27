package com.example.springproject.services;

import com.example.springproject.Entities.Foyer;
import com.example.springproject.Entities.Universite;
import com.example.springproject.repositiories.FoyerRepository;
import com.example.springproject.repositiories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository etud;
    FoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite Universite) {
        return etud.save(Universite);
    }

    @Override
    public List<Universite> listUniversite() {
        return  etud.findAll();
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return  etud.findById(idUniversite).get();
        //return chrep.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite Universite) {
        return  etud.save(Universite);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        etud.deleteById(idUniversite);
    }
    @Override
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) {
        Universite u = etud.findByNomUniversite(nomUniversite);
        Foyer f = foyerRepository.findById(idFoyer).get();
        u.setFoyer(f);

        return etud.save(u);
    }
    @Override
    public Universite desaffecterFoyerAUniversite (long idUniversite) {
        Universite universite = etud.findById(idUniversite).get();
        universite.setFoyer(null);
        return universite;
    }


}
