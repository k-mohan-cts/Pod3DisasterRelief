package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.Enum.reliefStatus;
import org.cognizant.disastermanagement.Enum.type;
import org.cognizant.disastermanagement.dao.DistributionRepository;
import org.cognizant.disastermanagement.dao.ReliefItemRepository;
import org.cognizant.disastermanagement.dto.request.ReliefItemRequestDTO;
import org.cognizant.disastermanagement.dto.response.ReliefItemResponseDTO;
import org.cognizant.disastermanagement.entity.ReliefItem;
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
class ReliefItemServiceTest {

    @Mock
    private ReliefItemRepository reliefItemsRepository;

    @Mock
    private DistributionRepository distributionRepository;

    @InjectMocks
    private ReliefItemService reliefItemService;

    private ReliefItem mockItem;
    private ReliefItemRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        mockItem = ReliefItem.builder()
                .itemId(1)
                .type(type.valueOf("MEDICINE"))
                .name("First Aid Kit")
                .quantity(100)
                .unit("Box")
                .status(reliefStatus.valueOf("AVAILABLE"))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        requestDTO = new ReliefItemRequestDTO();
        requestDTO.setType(type.valueOf("MEDICINE"));
        requestDTO.setName("First Aid Kit");
        requestDTO.setQuantity(100);
        requestDTO.setUnit("Box");
        requestDTO.setStatus(reliefStatus.valueOf("AVAILABLE"));
    }

    // ==========================================
    // PASSING TESTS (8 CASES)
    // ==========================================

    @Test
    @DisplayName("1. Should return relief item when valid ID is provided")
    void getReliefItemById_ValidId_ReturnsDTO() {
        when(reliefItemsRepository.findById(1)).thenReturn(Optional.of(mockItem));
        ReliefItemResponseDTO response = reliefItemService.getReliefItemById(1);
        assertNotNull(response);
        assertEquals(1, response.getItemId());
    }

    @Test
    @DisplayName("2. Should throw exception when relief item ID is not found")
    void getReliefItemById_InvalidId_ThrowsRuntimeException() {
        when(reliefItemsRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> reliefItemService.getReliefItemById(99));
    }

    @Test
    @DisplayName("3. Should successfully save a relief item")
    void saveReliefItem_ValidDTO_ReturnsSavedResponse() {
        when(reliefItemsRepository.save(any(ReliefItem.class))).thenReturn(mockItem);
        ReliefItemResponseDTO response = reliefItemService.saveReliefItem(requestDTO);
        assertNotNull(response);
        assertEquals("First Aid Kit", response.getName());
    }

    @Test
    @DisplayName("4. Should delete relief item successfully when not in use")
    void deleteReliefItem_ValidIdAndNotInUse_DeletesSuccessfully() {
        when(reliefItemsRepository.existsById(1)).thenReturn(true);
        when(distributionRepository.existsByItemId(1)).thenReturn(false);

        reliefItemService.deleteReliefItem(1);

        verify(reliefItemsRepository, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("5. Should throw exception when deleting an item that belongs to a distribution")
    void deleteReliefItem_ItemInUse_ThrowsException() {
        when(reliefItemsRepository.existsById(1)).thenReturn(true);
        when(distributionRepository.existsByItemId(1)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            reliefItemService.deleteReliefItem(1);
        });

        assertTrue(exception.getMessage().contains("Cannot delete: This item is currently assigned"));
        verify(reliefItemsRepository, never()).deleteById(anyInt());
    }

    @Test
    @DisplayName("6. Should update relief item when found by name")
    void updateReliefItem_ValidName_UpdatesSuccessfully() {
        when(reliefItemsRepository.findByName("First Aid Kit")).thenReturn(mockItem);
        when(reliefItemsRepository.save(any(ReliefItem.class))).thenReturn(mockItem);

        ReliefItemResponseDTO response = reliefItemService.updateReliefItem(requestDTO);

        assertNotNull(response);
        verify(reliefItemsRepository).save(any(ReliefItem.class));
    }

    @Test
    @DisplayName("7. Should throw exception when updating non-existent relief item by name")
    void updateReliefItem_InvalidName_ThrowsException() {
        when(reliefItemsRepository.findByName("First Aid Kit")).thenReturn(null);

        assertThrows(RuntimeException.class, () -> reliefItemService.updateReliefItem(requestDTO));
    }

    @Test
    @DisplayName("8. Should return empty list when no relief items exist")
    void getAllReliefItem_Empty_ReturnsEmptyList() {
        when(reliefItemsRepository.findAll()).thenReturn(Collections.emptyList());
        List<ReliefItemResponseDTO> result = reliefItemService.getAllReliefItem();
        assertTrue(result.isEmpty());
    }

    // ==========================================
    // FAILING TESTS (2 CASES)
    // ==========================================

    @Test
    @DisplayName("9. ⚠️ FAILING TEST: Should fail because we expect the wrong quantity")
    void getReliefItemById_MismatchedQuantity_Fails() {
        when(reliefItemsRepository.findById(1)).thenReturn(Optional.of(mockItem));

        ReliefItemResponseDTO response = reliefItemService.getReliefItemById(1);

        // This will fail because the mock has 100, but we are asserting 500
        assertEquals(500, response.getQuantity(), "Intentionally failing to show failures!");
    }

    @Test
    @DisplayName("10. ⚠️ FAILING TEST: Should fail because we expect a missing item to throw a specific custom message")
    void deleteReliefItem_WrongErrorMessage_Fails() {
        when(reliefItemsRepository.existsById(99)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            reliefItemService.deleteReliefItem(99);
        });

        // This will fail because the real message is "Relief Item not found with ID: 99"
        assertEquals("Oops, item gone!", exception.getMessage(), "Intentionally failing to show failures!");
    }
}