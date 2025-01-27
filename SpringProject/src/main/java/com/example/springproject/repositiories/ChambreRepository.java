package com.example.springproject.repositiories;

import com.example.springproject.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>{

    List<Chambre> findBybloc_NomBloc(String nomBloc);
    List<Chambre> findByReservations_anneeUniversitaireBetween(Date d1 , Date d2);

    Integer countByBloc_foyer_CapaciteFoyerGreaterThan (Long capacite);



   // Le nombre de chambres ayant une réservation non valide et dont l'année universitaire est inférieure à l'année universitaire courante.




    @Query("select c from Chambre c where  c.bloc.nomBloc = ?1")
    List<Chambre> findByBlocNameQuery(String nomBloc);

    @Query("select c from Chambre c join c.reservations reservations"
           +" where reservations.anneeUniversitaire between ?1 and ?2")
    List<Chambre> findByAnneeDeResQuery(Date startDate, Date endDate );


    @Query (" select count(c) from  Chambre c where c.bloc.foyer.capaciteFoyer > ?1")
    Integer calculet(Integer i);



    long countByReservations_EstValideFalseAndReservations_AnneeUniversitaireLessThan(Date currentYear);
    @Query ("SELECT COUNT(c) FROM Chambre c JOIN c.reservations r " +
                  " WHERE r.estValide = FALSE AND r.anneeUniversitaire < :currentYear")
    long countChambresWithInvalidReservationsAndPastYear(@Param("currentYear") Date currentYear);


public List<Chambre> findByNumerochambreIn(List<Long> l);

public  Chambre findByNumerochambre(Long n);

}
