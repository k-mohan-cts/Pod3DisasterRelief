package org.cognizant.disastermanagement.dto.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.cognizant.disastermanagement.Enum.DocType;
import org.cognizant.disastermanagement.Enum.VerificationStatus;

public class CitizenDocumentResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer documentId;
    private DocType docType;
    private String fileURI;
    private VerificationStatus verificationStatus;
    private LocalDateTime uploadedDate;

    public CitizenDocumentResponseDTO() {}

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getFileURI() {
        return fileURI;
    }

    public void setFileURI(String fileURI) {
        this.fileURI = fileURI;
    }

    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(VerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDateTime uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    @Override
    public String toString() {
        return "CitizenDocumentResponseDTO{" +
                "documentId=" + documentId +
                ", docType=" + docType +
                ", verificationStatus=" + verificationStatus +
                '}';
    }
}