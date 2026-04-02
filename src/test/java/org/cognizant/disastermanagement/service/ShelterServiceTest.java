package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.Enum.shelterStatus;
import org.cognizant.disastermanagement.dao.ShelterRepository;
import org.cognizant.disastermanagement.dto.request.ShelterRequestDTO;
import org.cognizant.disastermanagement.dto.response.ShelterResponseDTO;
import org.cognizant.disastermanagement.entity.Shelter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShelterServiceTest {

    @Mock
    private ShelterRepository shelterRepository;

    @InjectMocks
    private ShelterService shelterService;

    private Shelter mockShelter;
    private ShelterRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        mockShelter = Shelter.builder()
                .shelterId(1)
                .name("Central Safe Haven")
                .location("Downtown")
                .latitude(12.9716)
                .longitude(77.5946)
                .capacity(500)
                .occupancy(150)
                .status(shelterStatus.valueOf("OPEN"))
                .contactInfo("9876543210")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        requestDTO = new ShelterRequestDTO();
        requestDTO.setName("Central Safe Haven");
        requestDTO.setLocation("Downtown");
        requestDTO.setLatitude(12.9716);
        requestDTO.setLongitude(77.5946);
        requestDTO.setCapacity(500);
        requestDTO.setOccupancy(150);
        requestDTO.setStatus(shelterStatus.valueOf("OPEN"));
        requestDTO.setContactInfo("9876543210");
    }

    // ==========================================
    // PASSING TESTS (8 CASES)
    // ==========================================

    @Test
    @DisplayName("1. Should return shelter when valid ID is provided")
    void getShelterById_ValidId_ReturnsDTO() {
        when(shelterRepository.findById(1)).thenReturn(Optional.of(mockShelter));
        ShelterResponseDTO response = shelterService.getShelterById(1);
        assertNotNull(response);
        assertEquals(1, response.getShelterId());
    }

    @Test
    @DisplayName("2. Should throw exception when shelter ID is not found")
    void getShelterById_InvalidId_ThrowsRuntimeException() {
        when(shelterRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> shelterService.getShelterById(99));
    }

    @Test
    @DisplayName("3. Should successfully save a shelter")
    void addShelter_ValidDTO_ReturnsSavedResponse() {
        when(shelterRepository.save(any(Shelter.class))).thenReturn(mockShelter);
        ShelterResponseDTO response = shelterService.addShelter(requestDTO);
        assertNotNull(response);
        assertEquals("Central Safe Haven", response.getName());
    }

    @Test
    @DisplayName("4. Should return empty list when no shelters exist")
    void getAllShelters_EmptyList_ReturnsEmpty() {
        when(shelterRepository.findAll()).thenReturn(Collections.emptyList());
        List<ShelterResponseDTO> result = shelterService.getAllShelters();
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("5. Should delete shelter successfully when it exists")
    void deleteShelter_ValidId_DeletesSuccessfully() {
        when(shelterRepository.existsById(1)).thenReturn(true);

        shelterService.deleteShelter(1);

        verify(shelterRepository, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("6. Should throw exception when deleting non-existent shelter")
    void deleteShelter_InvalidId_ThrowsException() {
        when(shelterRepository.existsById(99)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> shelterService.deleteShelter(99));
        verify(shelterRepository, never()).deleteById(anyInt());
    }

    @Test
    @DisplayName("7. Should update shelter when found by name")
    void updateShelters_ValidName_UpdatesSuccessfully() {
        when(shelterRepository.findByName("Central Safe Haven")).thenReturn(mockShelter);
        when(shelterRepository.save(any(Shelter.class))).thenReturn(mockShelter);

        ShelterResponseDTO response = shelterService.updateShelters(requestDTO);

        assertNotNull(response);
        verify(shelterRepository).save(any(Shelter.class));
    }

    @Test
    @DisplayName("8. Should throw exception when updating non-existent shelter by name")
    void updateShelters_InvalidName_ThrowsException() {
        when(shelterRepository.findByName("Central Safe Haven")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> shelterService.updateShelters(requestDTO));
    }

    // ==========================================
    // FAILING TESTS (2 CASES)
    // ==========================================

    @Test
    @DisplayName("9. ⚠️ FAILING TEST: Should fail because we expect the wrong capacity")
    void getShelterById_MismatchedCapacity_Fails() {
        when(shelterRepository.findById(1)).thenReturn(Optional.of(mockShelter));

        ShelterResponseDTO response = shelterService.getShelterById(1);

        // This will fail because the mock has 500, but we are asserting 1000
        assertEquals(1000, response.getCapacity(), "Intentionally failing to show failures!");
    }

    @Test
    @DisplayName("10. ⚠️ FAILING TEST: Should fail because we expect a missing item to throw a specific custom message")
    void deleteShelter_WrongErrorMessage_Fails() {
        when(shelterRepository.existsById(99)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            shelterService.deleteShelter(99);
        });

        // This will fail because the real message starts with "Cannot delete: Shelter not found..."
        assertEquals("Delete operation failed drastically", exception.getMessage(), "Intentionally failing to show failures!");
    }
}