package com.example.springproject.repositiories;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {

    List<Foyer> findByBlocs_Chambres_NumerochambreIn(List<Long> chambreNumbers);
    @Query("SELECT DISTINCT f FROM Foyer f " +
            "JOIN f.blocs b JOIN b.chambres c " +
            "WHERE c.numerochambre IN :chambreNumbers")
    List<Foyer> findFoyersByChambreNumbers(@Param("chambreNumbers") List<Long> chambreNumbers);


}
