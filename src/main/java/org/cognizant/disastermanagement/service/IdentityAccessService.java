package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.*;
import org.cognizant.disastermanagement.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IdentityAccessService {
    @Autowired private UserRepository userRepository;
    @Autowired private AuditLogRepository auditLogRepository;

    public User createUser(User user) { return userRepository.save(user); }
    public List<User> getAllUsers() { return userRepository.findAll(); }

    public void logAction(AuditLog log) {
        auditLogRepository.save(log);
    }
}