package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.Enum.RecoveryStatus;
import org.cognizant.disastermanagement.dao.RecoveryProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecoveryServiceImpl implements RecoveryService {

    @Autowired
    private RecoveryProgramRepository programRepository;

    @Override
    public RecoveryProgram createProgram(RecoveryProgram program) {
        return programRepository.save(program);
    }

    @Override
    public List<RecoveryProgram> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public RecoveryProgram getProgramById(int id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found with id: " + id));
    }

    @Override
    public void cancelProgram(int id) {
        RecoveryProgram program = getProgramById(id);
        program.setStatus(RecoveryStatus.CANCELLED);
        programRepository.save(program);
    }

    @Override
    public void deleteProgram(int id) {
        if (!programRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Program not found.");
        }
        programRepository.deleteById(id);
    }
}