package com.example.courseenrollment.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public class EnrollmentDTO {
    private Integer enrollmentId;

    @NotNull
    private Integer studentId;

    @NotNull
    private Integer courseId;

    private LocalDate enrollDate;

    // getters/setters
    public Integer getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Integer enrollmentId) { this.enrollmentId = enrollmentId; }
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public LocalDate getEnrollDate() { return enrollDate; }
    public void setEnrollDate(LocalDate enrollDate) { this.enrollDate = enrollDate; }
}
