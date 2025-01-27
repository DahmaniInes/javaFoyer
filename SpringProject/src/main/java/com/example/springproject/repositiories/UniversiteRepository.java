package com.example.springproject.repositiories;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    public Universite findByNomUniversite(String nom);
}
