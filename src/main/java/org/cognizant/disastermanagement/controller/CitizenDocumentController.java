package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.cognizant.disastermanagement.service.CitizenDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class CitizenDocumentController {

    @Autowired
    private CitizenDocumentService documentService;

    @PostMapping
    public CitizenDocument uploadDocument(@RequestBody CitizenDocument doc) {
        return documentService.uploadDocument(doc);
    }

    @GetMapping("/{id}")
    public CitizenDocument getDocumentById(@PathVariable int id) {
        return documentService.getDocumentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable int id) {
        documentService.deleteDocument(id);
    }
}