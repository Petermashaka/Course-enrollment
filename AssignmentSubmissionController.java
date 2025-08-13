package com.example.newproject.controller;

import com.example.newproject.model.AssignmentSubmission;
import com.example.newproject.service.AssignmentSubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment-submissions")
public class AssignmentSubmissionController {

    private final AssignmentSubmissionService submissionService;

    public AssignmentSubmissionController(AssignmentSubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<AssignmentSubmission> getAllSubmissions() {
        return submissionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentSubmission> getSubmissionById(@PathVariable Integer id) {
        return submissionService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AssignmentSubmission> createSubmission(@RequestBody AssignmentSubmission submission) {
        AssignmentSubmission saved = submissionService.save(submission);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentSubmission> updateSubmission(@PathVariable Integer id, @RequestBody AssignmentSubmission submissionDetails) {
        return submissionService.getById(id)
                .map(existing -> {
                    existing.setAssignmentId(submissionDetails.getAssignmentId());
                    existing.setStudentId(submissionDetails.getStudentId());
                    existing.setSubmittedAt(submissionDetails.getSubmittedAt());
                    existing.setGrade(submissionDetails.getGrade());
                    AssignmentSubmission updated = submissionService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Integer id) {
        if (submissionService.getById(id).isPresent()) {
            submissionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
