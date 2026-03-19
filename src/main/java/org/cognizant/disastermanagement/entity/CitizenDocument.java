package org.cognizant.disastermanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.cognizant.disastermanagement.Enum.DocType;
import org.cognizant.disastermanagement.Enum.VerificationStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "CitizenDocument")
public class CitizenDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentID")
    private int documentId;

//    @ManyToOne
//    @JoinColumn(name = "CitizenID", nullable = false)
//    @JsonManagedReference
//    private Citizen citizen;


    @ManyToOne
    @JoinColumn(name = "CitizenID", nullable = false)
    @JsonIgnoreProperties({"documents", "user"})
    private Citizen citizen;









    @Enumerated(EnumType.STRING)
    @Column(name = "DocType", nullable = false)
    private DocType docType;

    @Column(name = "FileURI", nullable = false)
    private String fileURI;

    @Enumerated(EnumType.STRING)
    @Column(name = "VerificationStatus", nullable = false)
    private VerificationStatus verificationStatus;

    @CreationTimestamp
    @Column(name = "UploadedDate", updatable = false)
    private LocalDateTime uploadedDate;

    public CitizenDocument() {}

    public int getDocumentId() { return documentId; }
    public void setDocumentId(int documentId) { this.documentId = documentId; }

    public Citizen getCitizen() { return citizen; }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }

    public DocType getDocType() { return docType; }
    public void setDocType(DocType docType) { this.docType = docType; }

    public String getFileURI() { return fileURI; }
    public void setFileURI(String fileURI) { this.fileURI = fileURI; }

    public VerificationStatus getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public LocalDateTime getUploadedDate() { return uploadedDate; }
}
