package tn.esprit.spring.kaddem.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class EquipeServiceImplTest {
    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @Test
    public void testRetrieveAllEquipes() {
        // Given
        List<Equipe> mockEquipes = Arrays.asList(new Equipe(), new Equipe());
        when(equipeRepository.findAll()).thenReturn(mockEquipes);

        // When
        List<Equipe> result = equipeService.retrieveAllEquipes();

        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void testAddEquipe() {
        // Given
        Equipe equipeToAdd = new Equipe("TestEquipe", Niveau.JUNIOR);
        Equipe savedEquipe = new Equipe(1, "TestEquipe", Niveau.JUNIOR);
        when(equipeRepository.save(equipeToAdd)).thenReturn(savedEquipe);

        // When
        Equipe result = equipeService.addEquipe(equipeToAdd);

        // Then
        assertEquals(savedEquipe, result);
    }

    @Test
    public void testUpdateEquipe() {
        // Given
        Equipe equipeToUpdate = new Equipe(1, "UpdatedEquipe", Niveau.SENIOR);
        when(equipeRepository.save(equipeToUpdate)).thenReturn(equipeToUpdate);

        // When
        Equipe result = equipeService.updateEquipe(equipeToUpdate);

        // Then
        assertEquals(equipeToUpdate, result);
    }

    @Test
    public void testDeleteEquipe() {
        // Given
        Integer equipeIdToDelete = 1;
        Equipe equipeToDelete = new Equipe(equipeIdToDelete, "EquipeToDelete", Niveau.EXPERT);
        when(equipeRepository.findById(equipeIdToDelete)).thenReturn(Optional.of(equipeToDelete));

        // When
        equipeService.deleteEquipe(equipeIdToDelete);

        // Then
        verify(equipeRepository, times(1)).delete(equipeToDelete);

    }


}
