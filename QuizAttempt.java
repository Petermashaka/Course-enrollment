package com.example.newproject.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "quiz_attempts")
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Integer attemptId;

    @Column(name = "quiz_id", nullable = false)
    private Integer quizId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(nullable = false)
    private Integer score;

    @Column(name = "attempted_at", nullable = false)
    private LocalDate attemptedAt;

    public QuizAttempt() {}

    // Getters and setters
    public Integer getAttemptId() { return attemptId; }
    public void setAttemptId(Integer attemptId) { this.attemptId = attemptId; }

    public Integer getQuizId() { return quizId; }
    public void setQuizId(Integer quizId) { this.quizId = quizId; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public LocalDate getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDate attemptedAt) { this.attemptedAt = attemptedAt; }
}
