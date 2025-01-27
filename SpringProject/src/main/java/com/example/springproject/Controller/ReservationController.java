package com.example.springproject.Controller;

import com.example.springproject.Entities.Reservation;
import com.example.springproject.services.ReservationServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    ReservationServiceImpl RS;

    public List<Reservation> afficher(){
        return RS.listReservation();
    }

    @PostMapping("/add")
    public Reservation add(@RequestBody Reservation R){
        return RS.addReservation(R);
    }
}
