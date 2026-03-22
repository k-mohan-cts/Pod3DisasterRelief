package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.ComplainceType;

import java.io.Serializable;

/**
 * DTO for Compliance Dashboard data
 */
public class ComplianceDashboardDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long totalPending;
    private Long totalCompliant;
    private Long totalNonCompliant;
    private Long emergencyPending;
    private Long reliefPending;
    private Long programPending;
    private Double complianceRate;
    private Long nonComplianceRate;

    // Constructors
    public ComplianceDashboardDTO() {
    }

    public ComplianceDashboardDTO(Long totalPending, Long totalCompliant, Long totalNonCompliant,
                                 Long emergencyPending, Long reliefPending, Long programPending) {
        this.totalPending = totalPending;
        this.totalCompliant = totalCompliant;
        this.totalNonCompliant = totalNonCompliant;
        this.emergencyPending = emergencyPending;
        this.reliefPending = reliefPending;
        this.programPending = programPending;
        calculateMetrics();
    }

    // Calculate compliance metrics
    private void calculateMetrics() {
        long total = totalCompliant + totalNonCompliant;
        if (total > 0) {
            this.complianceRate = (double) (totalCompliant * 100) / total;
            this.nonComplianceRate = (long) (totalNonCompliant * 100) / total;
        }
    }

    // Getters and Setters
    public Long getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(Long totalPending) {
        this.totalPending = totalPending;
    }

    public Long getTotalCompliant() {
        return totalCompliant;
    }

    public void setTotalCompliant(Long totalCompliant) {
        this.totalCompliant = totalCompliant;
    }

    public Long getTotalNonCompliant() {
        return totalNonCompliant;
    }

    public void setTotalNonCompliant(Long totalNonCompliant) {
        this.totalNonCompliant = totalNonCompliant;
    }

    public Long getEmergencyPending() {
        return emergencyPending;
    }

    public void setEmergencyPending(Long emergencyPending) {
        this.emergencyPending = emergencyPending;
    }

    public Long getReliefPending() {
        return reliefPending;
    }

    public void setReliefPending(Long reliefPending) {
        this.reliefPending = reliefPending;
    }

    public Long getProgramPending() {
        return programPending;
    }

    public void setProgramPending(Long programPending) {
        this.programPending = programPending;
    }

    public Double getComplianceRate() {
        return complianceRate;
    }

    public void setComplianceRate(Double complianceRate) {
        this.complianceRate = complianceRate;
    }

    public Long getNonComplianceRate() {
        return nonComplianceRate;
    }

    public void setNonComplianceRate(Long nonComplianceRate) {
        this.nonComplianceRate = nonComplianceRate;
    }

    @Override
    public String toString() {
        return "ComplianceDashboardDTO{" +
                "totalPending=" + totalPending +
                ", totalCompliant=" + totalCompliant +
                ", totalNonCompliant=" + totalNonCompliant +
                ", complianceRate=" + complianceRate +
                '}';
    }
}
