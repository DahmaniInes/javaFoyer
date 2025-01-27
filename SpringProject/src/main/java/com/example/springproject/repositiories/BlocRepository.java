package com.example.springproject.repositiories;

import com.example.springproject.Entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    public Bloc findByNomBloc(String nom);

}
