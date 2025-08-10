package com.example.courseenrollment.controller;

import com.example.courseenrollment.model.Lesson;
import com.example.courseenrollment.repository.LessonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonRepository repo;

    public LessonController(LessonRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Lesson> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getById(@PathVariable Integer id) {
        Optional<Lesson> l = repo.findById(id);
        return l.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lesson> create(@RequestBody Lesson lesson) {
        Lesson saved = repo.save(lesson);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/by-course/{courseId}")
    public List<Lesson> byCourse(@PathVariable Integer courseId) {
        return repo.findByCourseId(courseId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> update(@PathVariable Integer id, @RequestBody Lesson lesson) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(lesson.getTitle());
            existing.setContent(lesson.getContent());
            existing.setCourseId(lesson.getCourseId());
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
