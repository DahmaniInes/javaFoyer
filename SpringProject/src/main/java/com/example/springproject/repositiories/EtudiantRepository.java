package com.example.springproject.repositiories;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByReservations_AnneeUniversitaireAndReservations_EstValideTrue(Date anneeUniversitaire);
    @Query("SELECT e.nomEt FROM Etudiant e JOIN e.reservations r "
            + "WHERE r.anneeUniversitaire = :currentYear AND r.estValide = TRUE")
    // lezem fi service annee mta3 tawa
    List<String> findNomEtudiantsValidReservationsAnneeCourante(@Param("currentYear") Date currentYear);

}
