package com.example.courseenrollment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lessonId;

    private Integer courseId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
}
