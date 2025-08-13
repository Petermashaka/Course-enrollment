package com.example.newproject.service;

import com.example.newproject.model.Assignment;
import com.example.newproject.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getById(Integer id) {
        return assignmentRepository.findById(id);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteById(Integer id) {
        assignmentRepository.deleteById(id);
    }
}
