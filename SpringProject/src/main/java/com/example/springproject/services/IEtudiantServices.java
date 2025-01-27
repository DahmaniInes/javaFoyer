package com.example.springproject.services;

import com.example.springproject.Entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    public Etudiant addEtudiant(Etudiant etudiant);
    public List<Etudiant> listEtudiant();
    public  Etudiant getEtudiantById(Long idEtudiant);
    public Etudiant updateEtudiant (Etudiant etudiant);

    public  void deleteEtudiant(Long idEtudiant);
}
