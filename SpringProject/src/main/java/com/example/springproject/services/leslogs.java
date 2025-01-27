package com.example.springproject.services;

import com.example.springproject.Entities.Chambre;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Aspect
public class leslogs {
    private static final Logger l = LogManager.getLogger(ChambreServiceImpl.class);

    @AfterThrowing(pointcut = "execution(* com.example.springproject.services.ChambreServiceImpl.listChambre(..))", throwing = "ex")
    public void logAfterMethodThrows(Exception ex) {
        l.error("Erreur lors de l'exécution de listChambre : {}", ex.getMessage());
    }

    @After("execution(* com.example.springproject.services.ChambreServiceImpl.listChambre())")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
         //List<Chambre> chambres = (List<Chambre>) joinPoint.getResult();
        l.info("Méthode listChambre exécutée avec succès ! Nombre de chambres retournées : {}");
    }
}
