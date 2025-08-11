package com.example.courseenrollment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentId;

    // Remove these plain ID fields:
    // private Integer studentId;
    // private Integer courseId;

    // Add this ManyToOne relation to Course:
    @ManyToOne(fetch = FetchType.LAZY)  // lazy fetch optional but recommended
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDate enrollDate;

    public Integer getId() {
        return enrollmentId;
    }
}
