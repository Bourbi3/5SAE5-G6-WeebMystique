package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.Date;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratServiceImplTest {
    @Autowired
    ContratServiceImpl contratService;
    @Test
    @Order(1)
    public void TestAddContrat(){
        Contrat contrat = new Contrat();
        contrat.setArchive(true);
        contrat.setMontantContrat(700);
        contrat.setDateDebutContrat(new Date());
        contrat.setDateFinContrat(new Date());
        contrat.setSpecialite(Specialite.CLOUD);
        contrat.setEtudiant(new Etudiant("Zgolli","Khaled"));
        contratService.addContrat(contrat);

        Assertions.assertNotNull(contratService.retrieveContrat(contrat.getIdContrat()));

    }

}
