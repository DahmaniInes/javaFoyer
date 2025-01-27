package com.example.springproject.services;

import com.example.springproject.Entities.Etudiant;
import com.example.springproject.repositiories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements IEtudiantServices{

    EtudiantRepository etud;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etud.save(etudiant);
    }

    @Override
    public List<Etudiant> listEtudiant() {
        return  etud.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return  etud.findById(idEtudiant).get();
        //return chrep.findById(idEtudiant).orElse(null);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant Etudiant) {
        return  etud.save(Etudiant);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etud.deleteById(idEtudiant);
    }


}
