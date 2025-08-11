package com.example.courseenrollment.dto;

import jakarta.validation.constraints.NotBlank;

public class LessonDTO {
    private Integer lessonId;
    private Integer courseId;

    @NotBlank
    private String title;
    private String content;

    // getters/setters
    public Integer getLessonId() { return lessonId; }
    public void setLessonId(Integer lessonId) { this.lessonId = lessonId; }
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
