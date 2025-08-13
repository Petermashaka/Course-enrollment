package com.example.newproject.service;

import com.example.newproject.model.AssignmentSubmission;
import com.example.newproject.repository.AssignmentSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionService {

    private final AssignmentSubmissionRepository submissionRepository;

    public AssignmentSubmissionService(AssignmentSubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public List<AssignmentSubmission> getAll() {
        return submissionRepository.findAll();
    }

    public Optional<AssignmentSubmission> getById(Integer id) {
        return submissionRepository.findById(id);
    }

    public AssignmentSubmission save(AssignmentSubmission submission) {
        return submissionRepository.save(submission);
    }

    public void deleteById(Integer id) {
        submissionRepository.deleteById(id);
    }
}
