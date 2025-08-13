package com.example.newproject.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignment_submissions")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Integer submissionId;

    @Column(name = "assignment_id", nullable = false)
    private Integer assignmentId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "submitted_at", nullable = false)
    private LocalDate submittedAt;

    private Float grade;

    public AssignmentSubmission() {}

    // Getters and setters
    public Integer getSubmissionId() { return submissionId; }
    public void setSubmissionId(Integer submissionId) { this.submissionId = submissionId; }

    public Integer getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Integer assignmentId) { this.assignmentId = assignmentId; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public LocalDate getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDate submittedAt) { this.submittedAt = submittedAt; }

    public Float getGrade() { return grade; }
    public void setGrade(Float grade) { this.grade = grade; }
}
