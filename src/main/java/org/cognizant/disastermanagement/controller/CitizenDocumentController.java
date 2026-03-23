package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.request.CitizenDocumentRequestDTO;
import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.cognizant.disastermanagement.service.CitizenDocumentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class CitizenDocumentController {

    private final CitizenDocumentService documentService;

    public CitizenDocumentController(CitizenDocumentService documentService) {
        this.documentService = documentService;
    }

    // ✅ UPLOAD DOCUMENT
    @PostMapping("/upload")
    public ResponseEntity<CitizenDocument> uploadDocument(
            @Valid @RequestBody CitizenDocumentRequestDTO requestDTO) {

        CitizenDocument savedDoc = documentService.uploadDocument(requestDTO);
        return new ResponseEntity<>(savedDoc, HttpStatus.CREATED);
    }

    // ✅ GET BY ID
    @GetMapping("/getDocById/{id}")
    public ResponseEntity<CitizenDocument> getDocumentById(@PathVariable int id) {
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    // ✅ DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable int id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully");
    }
}