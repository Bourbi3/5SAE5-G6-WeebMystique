package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartementServiceImplTest {

    @Autowired
    IDepartementService service;

    @MockBean
    DepartementRepository repository;

    @Test
    @Order(1)
    void addDepartementTest() {
        Departement d = new Departement();
        d.setNomDepart("IT");

        given(this.repository.save(d)).willReturn(d);
        Departement savedDepartment = service.addDepartement(d);
        verify(repository).save(d);
        Assertions.assertEquals(d.getNomDepart(),savedDepartment.getNomDepart());
    }
    @Test
    @Order(2)
    void retrieveDepartementTest(){
        Departement department = new Departement();
        department.setIdDepart(1); // Set a known ID
        department.setNomDepart("IT");

        given(repository.findById(1)).willReturn(Optional.of(department));
        Departement retrievedDepartment = service.retrieveDepartement(1);

        Assertions.assertEquals(1, retrievedDepartment.getIdDepart()); // Check if the ID matches
        Assertions.assertEquals("IT", retrievedDepartment.getNomDepart()); // Check if the name matches

    }
    @Test
    @Order(3)
    void retrieveAllDepartementsTest() {
        Departement department = new Departement();
        department.setNomDepart("IT");

        given(repository.save(department)).willReturn(department);
        Departement savedDepartment = service.addDepartement(department);
        given(repository.findAll()).willReturn(Collections.singletonList(savedDepartment));
        List<Departement> departmentList = service.retrieveAllDepartements();

        Assertions.assertEquals(1, departmentList.size());
        Assertions.assertEquals("IT", departmentList.get(0).getNomDepart());
    }
}
