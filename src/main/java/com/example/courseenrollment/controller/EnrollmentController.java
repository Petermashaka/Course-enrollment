package com.example.courseenrollment.controller;

import com.example.courseenrollment.model.Enrollment;
import com.example.courseenrollment.repository.EnrollmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository repo;

    public EnrollmentController(EnrollmentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Enrollment> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable Integer id) {
        Optional<Enrollment> e = repo.findById(Long.valueOf(id));
        return e.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) {
        if (enrollment.getEnrollDate() == null) enrollment.setEnrollDate(LocalDate.now());
        Enrollment saved = repo.save(enrollment);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/by-student/{studentId}")
    public List<Enrollment> byStudent(@PathVariable Integer studentId) {
        return repo.findAll();
    }

    @GetMapping("/by-course/{courseId}")
    public List<Enrollment> byCourse(@PathVariable Integer courseId) {
        return repo.findByCourseId(courseId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repo.existsById(Long.valueOf(id))) {
            repo.deleteById(Long.valueOf(id));
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
