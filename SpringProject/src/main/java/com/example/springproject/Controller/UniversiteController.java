package com.example.springproject.Controller;

import com.example.springproject.Entities.Universite;
import com.example.springproject.services.UniversiteServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Universite")
public class UniversiteController {
UniversiteServiceImpl universiteService;
    @PutMapping("/affeterBlocToUniversite/{nomUniversite}/{idFoyer}")
    public Universite affeterBlocToUniversite(@RequestBody String nomUniversite , @PathVariable("idFoyer")  Long idFoyer ) {
        Universite Universite = universiteService.affecterFoyerAUniversite(idFoyer ,nomUniversite);
        return Universite;
    }
}
