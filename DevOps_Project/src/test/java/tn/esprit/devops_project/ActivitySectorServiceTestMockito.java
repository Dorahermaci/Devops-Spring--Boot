import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public ActivitySectorServiceTestMockito {

    @InjectMocks
    ActivitySectorImpl activitySectorService;

    @Mock
    ActivitySectorRepository activitySectorRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllActivitySectors() {
        List<ActivitySector> activitySectors = new ArrayList<>();
        // Add test data to the list

        when(activitySectorRepository.findAll()).thenReturn(activitySectors);

        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();

        assertEquals(activitySectors, result);
    }

    @Test
    public void testAddActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        // Set properties for the test activity sector

        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);

        ActivitySector result = activitySectorService.addActivitySector(activitySector);

        assertEquals(activitySector, result);
    }

    @Test
    public void testDeleteActivitySector() {
        Long idToDelete = 1L;

        activitySectorService.deleteActivitySector(idToDelete);

        verify(activitySectorRepository).deleteById(idToDelete);
    }

    @Test
    public void testUpdateActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        // Set properties for the test activity sector

        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);

        ActivitySector result = activitySectorService.updateActivitySector(activitySector);

        assertEquals(activitySector, result);
    }

    @Test
    public void testRetrieveActivitySector() {
        Long idToRetrieve = 1L;
        ActivitySector activitySector = new ActivitySector();
        // Set properties for the test activity sector

        when(activitySectorRepository.findById(idToRetrieve)).thenReturn(Optional.of(activitySector));

        ActivitySector result = activitySectorService.retrieveActivitySector(idToRetrieve);

        assertEquals(activitySector, result);
    }
}
