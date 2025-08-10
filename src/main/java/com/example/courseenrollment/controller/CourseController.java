package com.example.courseenrollment.controller;

import com.example.courseenrollment.model.Course;
import com.example.courseenrollment.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository repo;

    public CourseController(CourseRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Course> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Integer id) {
        Optional<Course> c = repo.findById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody Course course) {
        Course saved = repo.save(course);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Integer id, @Valid @RequestBody Course course) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(course.getTitle());
            existing.setDescription(course.getDescription());
            existing.setInstructorId(course.getInstructorId());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
