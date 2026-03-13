package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.EmergencyReportRequest;
import org.cognizant.disastermanagement.dao.EmergencyReportResponse;

import java.util.ArrayList;
import java.util.List;

public class EmergencyReportService {
    public EmergencyReportResponse createReport(EmergencyReportRequest request) {
        return new EmergencyReportResponse();
    }

    public List<EmergencyReportResponse> getAllReports() {
        return new ArrayList<>();
    }

    public EmergencyReportResponse getReportById(Integer reportId) {
        return new EmergencyReportResponse();
    }

    public EmergencyReportResponse updateStatus(Integer reportId, String status) {
        return new EmergencyReportResponse();
    }
}
