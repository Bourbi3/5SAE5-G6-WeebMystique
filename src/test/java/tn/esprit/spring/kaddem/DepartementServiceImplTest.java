package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartementServiceImplTest {

    @Autowired
    IDepartementService service;
    @Test
    @Order(1)
    public void TestAddContrat(){
        Departement departement = new Departement();
        departement.setNomDepart("info");

       service.addDepartement(departement );

        Assertions.assertNotNull(service.retrieveDepartement(departement.getIdDepart()));

    }
    @Test
    @Order(2)
    public void testRetrieveAllContrat() {
        List<Departement> listProduits = service.retrieveAllDepartements();
        //  Assertions.assertEquals(0, listProduits.size());
        Assertions.assertNotEquals(0,listProduits.size());
    }
}
