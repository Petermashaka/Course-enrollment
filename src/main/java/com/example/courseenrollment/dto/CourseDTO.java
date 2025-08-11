package com.example.courseenrollment.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseDTO {
    private Integer courseId;

    @NotBlank
    private String title;
    private String description;
    private Integer instructorId;

    // getters/setters
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getInstructorId() { return instructorId; }
    public void setInstructorId(Integer instructorId) { this.instructorId = instructorId; }
}
