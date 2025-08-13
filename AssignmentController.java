package com.example.newproject.controller;

import com.example.newproject.model.Assignment;
import com.example.newproject.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Integer id) {
        return assignmentService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment savedAssignment = assignmentService.save(assignment);
        return new ResponseEntity<>(savedAssignment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Integer id, @RequestBody Assignment assignmentDetails) {
        return assignmentService.getById(id)
                .map(existingAssignment -> {
                    existingAssignment.setLessonId(assignmentDetails.getLessonId());
                    existingAssignment.setTitle(assignmentDetails.getTitle());
                    existingAssignment.setDescription(assignmentDetails.getDescription());
                    Assignment updated = assignmentService.save(existingAssignment);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Integer id) {
        if (assignmentService.getById(id).isPresent()) {
            assignmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
