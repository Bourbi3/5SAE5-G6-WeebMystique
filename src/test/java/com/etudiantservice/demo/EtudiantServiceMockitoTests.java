package com.etudiantservice.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {EtudiantServiceMockitoTests.class})

public class EtudiantServiceMockitoTests {


    @Mock
    EtudiantRepository etudiantrep;
    @InjectMocks
    EtudiantServiceImpl etudiantService;

    public Etudiant etudiant;

    public List<Etudiant> Etudiants;
    @Test
     @Order(1)
    public void test_retrieveAllEtudiants() {
       List<Etudiant> Etudiants=new ArrayList<Etudiant>();
       Etudiants.add(new Etudiant("Ahmed","dhouieb"));
       Etudiants.add(new Etudiant("Sana","dhouieb)"));

       when(etudiantrep.findAll()).thenReturn(Etudiants); //Mocking
       assertEquals(2,etudiantService.retrieveAllEtudiants().size());
    }
   //  @Test
    //@Order(6)
   // public void test_retrieveEtudiantById() {
       //  Etudiants.add(new Etudiant("Sana", "dhouieb)"));
        // int idEtudiant = 1;
        // Mockito.when(etudiantrep.findById(idEtudiant)).thenReturn(Optional.of(etudiant));
        // assertThat(etudiantService.retrieveEtudiant(idEtudiant)).isEqualTo(etudiant);
    //  }
        // when(etudiantrep.findById(1).get()).thenReturn(Optional.of(etudiant)); //mocking
        // assertEquals(idEtudiant,etudiantService.retrieveEtudiant(idEtudiant).getIdEtudiant());
    // }

   // @Test
   // @Order(6)
   // public void test_retrieveEtudiantById() {
      //  Etudiants.add(new Etudiant(1, "sana", "dhouieb", Option.GAMIX ));
       // when(etudiantrep.findById(1)).thenReturn(Optional.of(etudiant));
   // }


   // @Test
    //@Order(2)
   // public void test_retrieveEtudiantBydepartement()
     //{
 //List<Etudiant> Etudiants=new ArrayList<Etudiant>();
    // Etudiants.add(new Etudiant("Ahmed","dhouieb"));
     // Etudiants.add(new Etudiant("Sana","dhouieb)"));
      //int idDepart =1;
     //when(etudiantrep.findEtudiantsByDepartement_IdDepart(idDepart)).thenReturn(Etudiants); //mocking
    // assertEquals(1,etudiantService.getEtudiantsByDepartement(idDepart).get(idDepart));
    //}

    @Test
    @Order(2)
    public void test_addEtudiant()
    {
        Etudiant etudiant=new Etudiant("mohamed","ahmed");
        when(etudiantrep.save(etudiant)).thenReturn(etudiant);
        assertEquals(etudiant,etudiantService.addEtudiant(etudiant));
    }

    @Test
    @Order(3)
    public void test_updateEtudiant()
    {
        Etudiant etudiant = new Etudiant("habib","dhouieb");
        when(etudiantrep.save(etudiant)).thenReturn(etudiant);
        assertEquals(etudiant,etudiantService.updateEtudiant(etudiant));

    }

}
