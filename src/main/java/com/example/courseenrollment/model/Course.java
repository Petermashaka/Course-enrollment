package com.example.courseenrollment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @NotBlank
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer instructorId;

    public Integer getId() {
        return courseId;
    }
}
