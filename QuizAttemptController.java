package com.example.newproject.controller;

import com.example.newproject.model.QuizAttempt;
import com.example.newproject.service.QuizAttemptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-attempts")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    @GetMapping
    public List<QuizAttempt> getAllQuizAttempts() {
        return quizAttemptService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizAttempt> getQuizAttemptById(@PathVariable Integer id) {
        return quizAttemptService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuizAttempt> createQuizAttempt(@RequestBody QuizAttempt quizAttempt) {
        QuizAttempt saved = quizAttemptService.save(quizAttempt);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizAttempt> updateQuizAttempt(@PathVariable Integer id, @RequestBody QuizAttempt quizAttemptDetails) {
        return quizAttemptService.getById(id)
                .map(existing -> {
                    existing.setQuizId(quizAttemptDetails.getQuizId());
                    existing.setStudentId(quizAttemptDetails.getStudentId());
                    existing.setScore(quizAttemptDetails.getScore());
                    existing.setAttemptedAt(quizAttemptDetails.getAttemptedAt());
                    QuizAttempt updated = quizAttemptService.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizAttempt(@PathVariable Integer id) {
        if (quizAttemptService.getById(id).isPresent()) {
            quizAttemptService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
