package org.cognizant.disastermanagement.service;
import org.cognizant.disastermanagement.entity.RecoveryProgram;
import java.util.List;
public interface RecoveryService {
    RecoveryProgram createProgram(RecoveryProgram program);
    List<RecoveryProgram> getAllPrograms();
    RecoveryProgram getProgramById(int id);
    void cancelProgram(int id);
    void deleteProgram(int id);
}