package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;
import org.cognizant.disastermanagement.Enum.DocType;
import org.cognizant.disastermanagement.Enum.VerificationStatus;

public class CitizenDocumentRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer citizenId;
    private DocType docType;
    private String fileURI;
    private VerificationStatus verificationStatus;

    public CitizenDocumentRequestDTO() {}

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
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

    @Override
    public String toString() {
        return "CitizenDocumentRequestDTO{" +
                "citizenId=" + citizenId +
                ", docType=" + docType +
                ", verificationStatus=" + verificationStatus +
                '}';
    }
}
