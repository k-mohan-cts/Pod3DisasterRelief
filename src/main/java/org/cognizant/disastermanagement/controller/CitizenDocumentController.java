package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.cognizant.disastermanagement.service.CitizenDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class CitizenDocumentController {

    @Autowired
    private CitizenDocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<CitizenDocument> uploadDocument(@RequestBody CitizenDocument doc) {
        CitizenDocument savedDoc = documentService.uploadDocument(doc);
        return new ResponseEntity<>(savedDoc, HttpStatus.CREATED);
    }

    @GetMapping("/getDocById/{id}")
    public ResponseEntity<CitizenDocument> getDocumentById(@PathVariable int id) {
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable int id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully");
    }
}