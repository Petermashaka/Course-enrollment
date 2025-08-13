package com.example.newproject.service;

import com.example.newproject.model.QuizAttempt;
import com.example.newproject.repository.QuizAttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;

    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public List<QuizAttempt> getAll() {
        return quizAttemptRepository.findAll();
    }

    public Optional<QuizAttempt> getById(Integer id) {
        return quizAttemptRepository.findById(id);
    }

    public QuizAttempt save(QuizAttempt quizAttempt) {
        return quizAttemptRepository.save(quizAttempt);
    }

    public void deleteById(Integer id) {
        quizAttemptRepository.deleteById(id);
    }
}
