package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.Enum.distributionStatus;
import org.cognizant.disastermanagement.dao.DistributionRepository;
import org.cognizant.disastermanagement.dto.request.DistributionRequestDTO;
import org.cognizant.disastermanagement.dto.response.DistributionResponseDTO;
import org.cognizant.disastermanagement.entity.Distribution;
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
class DistributionServiceTest {

    @Mock
    private DistributionRepository distributionRepository;

    @InjectMocks
    private DistributionService distributionService;

    private Distribution mockDistribution;
    private DistributionRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        mockDistribution = Distribution.builder()
                .distributionId(1)
                .itemId(101)
                .citizenId(202)
                .officerId(303)
                .quantity(5)
                .notes("Emergency supplies")
                .date(LocalDateTime.now())
                .status(distributionStatus.PENDING)
                .build();

        requestDTO = new DistributionRequestDTO();
        requestDTO.setDistributionId(1);
        requestDTO.setItemId(101);
        requestDTO.setCitizenId(202);
        requestDTO.setOfficerId(303);
        requestDTO.setQuantity(5);
        requestDTO.setNotes("Emergency supplies");
        requestDTO.setStatus("PENDING");
    }

    // PASSING TESTS (8 CASES)

    @Test
    @DisplayName("1. Should return distribution when valid ID is provided")
    void getDistributionById_ValidId_ReturnsDTO() {
        when(distributionRepository.findById(1)).thenReturn(Optional.of(mockDistribution));
        DistributionResponseDTO response = distributionService.getDistributionById(1);
        assertNotNull(response);
        assertEquals(1, response.getDistributionId());
    }

    @Test
    @DisplayName("2. Should throw exception when distribution ID is not found")
    void getDistributionById_InvalidId_ThrowsRuntimeException() {
        when(distributionRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> distributionService.getDistributionById(99));
    }

    @Test
    @DisplayName("3. Should successfully save a distribution")
    void saveDistribution_ValidDTO_ReturnsSavedResponse() {
        when(distributionRepository.save(any(Distribution.class))).thenReturn(mockDistribution);
        DistributionResponseDTO response = distributionService.saveDistribution(requestDTO);
        assertNotNull(response);
        assertEquals(1, response.getDistributionId());
    }

    @Test
    @DisplayName("4. Should throw exception when attempting to delete non-existent distribution")
    void deleteDistribution_InvalidId_ThrowsException() {
        when(distributionRepository.existsById(99)).thenReturn(false);
        assertThrows(RuntimeException.class, () -> distributionService.deleteDistribution(99));
    }

    @Test
    @DisplayName("5. Should return empty list when no distributions exist")
    void getAllDistributions_EmptyList_ReturnsEmpty() {
        when(distributionRepository.findAll()).thenReturn(Collections.emptyList());
        List<DistributionResponseDTO> result = distributionService.getAllDistributions();
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("6. Should fallback to PENDING when saving with null status")
    void saveDistribution_NullStatus_FallsBackToPending() {
        requestDTO.setStatus(null);
        when(distributionRepository.save(any(Distribution.class))).thenReturn(mockDistribution);

        distributionService.saveDistribution(requestDTO);

        // Verifies that the entity sent to the DB actually had PENDING set
        verify(distributionRepository).save(argThat(entity ->
                entity.getStatus() == distributionStatus.PENDING
        ));
    }

    @Test
    @DisplayName("7. Should fallback to 0 quantity when saving with null quantity")
    void saveDistribution_NullQuantity_FallsBackToZero() {
        requestDTO.setQuantity(null);
        when(distributionRepository.save(any(Distribution.class))).thenReturn(mockDistribution);

        distributionService.saveDistribution(requestDTO);

        verify(distributionRepository).save(argThat(entity ->
                entity.getQuantity() == 0
        ));
    }

    @Test
    @DisplayName("8. Should update only provided fields without overwriting others")
    void updateDistribution_PartialUpdate_PreservesUnchangedFields() {
        DistributionRequestDTO partialRequest = new DistributionRequestDTO();
        partialRequest.setDistributionId(1);
        partialRequest.setNotes("Updated Notes"); // ONLY updating notes

        when(distributionRepository.findById(1)).thenReturn(Optional.of(mockDistribution));
        when(distributionRepository.save(any(Distribution.class))).thenReturn(mockDistribution);

        distributionService.updateDistribution(partialRequest);

        // Verify that original fields (like quantity) were preserved and not set to null
        verify(distributionRepository).save(argThat(entity ->
                entity.getNotes().equals("Updated Notes") && entity.getQuantity() == 5
        ));
    }

    // FAILING TESTS (2 CASES)

    @Test
    @DisplayName("9. ⚠️ FAILING TEST: Should fail because we expect wrong status")
    void getDistributionById_MismatchedExpectation_Fails() {
        when(distributionRepository.findById(1)).thenReturn(Optional.of(mockDistribution));

        DistributionResponseDTO response = distributionService.getDistributionById(1);

        // This will fail because the mock status is "PENDING", but we are asserting "APPROVED"
        assertEquals("APPROVED", response.getStatus(), "Intentionally failing to show failures!");
    }

    @Test
    @DisplayName("10. ⚠️ FAILING TEST: Should fail because we expect the wrong exception message")
    void deleteDistribution_WrongErrorMessage_Fails() {
        when(distributionRepository.existsById(99)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            distributionService.deleteDistribution(99);
        });

        // This will fail because the real message is "Distribution record not found with ID: 99"
        assertEquals("Invalid ID provided", exception.getMessage(), "Intentionally failing to show failures!");
    }
}