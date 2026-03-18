package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.cognizant.disastermanagement.Enum.RecoveryStatus;
import java.time.LocalDate;
import java.util.List;

public class RecoveryProgramDTO {
    private int programId;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 50, message = "Title must be between 10 and 50 characters")
    private String title;

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private RecoveryStatus status;
    private List<ResourceDTO> resources;

    public int getProgramId() { return programId; }
    public void setProgramId(int programId) { this.programId = programId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public RecoveryStatus getStatus() { return status; }
    public void setStatus(RecoveryStatus status) { this.status = status; }
    public List<ResourceDTO> getResources() { return resources; }
    public void setResources(List<ResourceDTO> resources) { this.resources = resources; }
}