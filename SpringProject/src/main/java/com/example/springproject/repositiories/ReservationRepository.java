package com.example.springproject.repositiories;

import com.example.springproject.Entities.Bloc;
import com.example.springproject.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
