package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="CitizenDocument")
public class CitizenDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @ManyToOne
    @JoinColumn(name = "CitizenID")
    private Citizen citizen;

    private String docType;

    @Column(length = 500)
    private String fileURI;

    private LocalDateTime uploadedDate;
    private String verificationStatus;

    @ManyToOne
    @JoinColumn(name = "VerifiedBy")
    private User verifiedBy;

    private LocalDateTime verifiedAt;

    public CitizenDocument() {}

    // Getters and Setters
    public int getDocumentId()
    {
        return documentId;
    }
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }
    public Citizen getCitizen() {
        return citizen;
    }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }
    public String getDocType() { return docType; }
    public void setDocType(String docType) { this.docType = docType; }
    public String getFileURI() { return fileURI; }
    public void setFileURI(String fileURI) { this.fileURI = fileURI; }
    public LocalDateTime getUploadedDate() { return uploadedDate; }
    public void setUploadedDate(LocalDateTime uploadedDate) { this.uploadedDate = uploadedDate; }
    public String getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(String verificationStatus) { this.verificationStatus = verificationStatus; }
    public User getVerifiedBy() { return verifiedBy; }
    public void setVerifiedBy(User verifiedBy) { this.verifiedBy = verifiedBy; }
    public LocalDateTime getVerifiedAt() { return verifiedAt; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }
}