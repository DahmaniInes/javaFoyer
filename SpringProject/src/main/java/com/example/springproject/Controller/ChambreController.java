package com.example.springproject.Controller;

import com.example.springproject.Entities.Chambre;
import com.example.springproject.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {

        IChambreService chambreService;

        @GetMapping("/retrieve-all-chambres")
        public List<Chambre> getChambres() {
            List<Chambre> listChambres = chambreService.listChambre();
            return listChambres;
        }

        @GetMapping("/retrieve-chambre/{chId}")
        public Chambre retrieveChambre(@PathVariable  Long chId) {
            Chambre chambre = chambreService.getChambreById(chId);
            return chambre;
        }


    @GetMapping("/findBybloc_NomBloc/{nom}")
    public List<Chambre> listchambre(@PathVariable  String nom) {
        List<Chambre> chambre = chambreService.chambresSelonNomBloc(nom);
        return chambre;
    }


    //http://localhost:8081/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }


    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.deleteChambre(chId);
    }



    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }


    @PostMapping("/add-list-chambre")
    public List<Chambre> addListChambre(@RequestBody List<Chambre> c) {
        List<Chambre> chambres = chambreService.addListChambre(c);
        return chambres;
    }


    @PostMapping("/nbChambreParCapaciteFoyerKeyword/{c}")
    public Integer nbChambreParCapaciteFoyerKeyword(@PathVariable Long c) {
       return chambreService.nbChambreParCapaciteFoyerKeyword(c);

    }


    @GetMapping("/find-selon-annee_res/{d1}/{d2}")
    public List<Chambre> findByReservation_AnneeUniversitaireBetween(
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d1 ,
            @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d2) {
        return chambreService.findByReservationAvecUnDateSpecifique(d1 ,d2);
    }

    



}


