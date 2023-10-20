package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.Date;
import java.util.List;

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
    @Test
    @Order(2)
    public void testRetrieveAllContrat() {
        List<Contrat> listProduits = contratService.retrieveAllContrats();
        //  Assertions.assertEquals(0, listProduits.size());
        Assertions.assertNotEquals(0,listProduits.size());
    }
/*
    @Test
    @Order(3)
    public void testUpdate(){
        Contrat c = contratService.retrieveContrat(1);
        c.setSpecialite(Specialite.IA);
        c.setArchive(true);
        c.setMontantContrat(500);
        c.setDateDebutContrat(new Date());
        c.setDateFinContrat(new Date());
        c.setEtudiant(new Etudiant("ben cheikh","rabie"));
        contratService.addContrat(c);
        Assertions.assertNotEquals(500,contratService.retrieveContrat(1).getMontantContrat());

    }
*/
}
