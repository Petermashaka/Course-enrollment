package com.example.courseenrollment.services;

import com.example.courseenrollment.dto.EnrollmentDTO;
import com.example.courseenrollment.exception.ResourceNotFoundException;
import com.example.courseenrollment.model.Enrollment;
import com.example.courseenrollment.model.Course;
import com.example.courseenrollment.repository.EnrollmentRepository;
import com.example.courseenrollment.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repo;
    private final CourseRepository courseRepo;

    public EnrollmentService(EnrollmentRepository repo, CourseRepository courseRepo) {
        this.repo = repo;
        this.courseRepo = courseRepo;
    }

    public List<EnrollmentDTO> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public EnrollmentDTO create(EnrollmentDTO dto) {
        // validate course exists
        Course c = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", dto.getCourseId()));

        Enrollment e = new Enrollment();
        e.setCourse(c);
        e.setEnrollDate(dto.getEnrollDate() == null ? LocalDate.now() : dto.getEnrollDate());
        Enrollment saved = repo.save(e);
        return toDto(saved);
    }

    public List<EnrollmentDTO> findByCourse(Long courseId) {
        return repo.findByCourseId(courseId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private EnrollmentDTO toDto(Enrollment e) {
        EnrollmentDTO d = new EnrollmentDTO();
        d.setEnrollmentId(e.getId());
        d.setCourseId(e.getCourse().getId());
        d.setEnrollDate(e.getEnrollDate());
        return d;
    }
}
