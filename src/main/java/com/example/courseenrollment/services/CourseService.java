package com.example.courseenrollment.services;

import com.example.courseenrollment.dto.CourseDTO;
import com.example.courseenrollment.exception.ResourceNotFoundException;
import com.example.courseenrollment.model.Course;
import com.example.courseenrollment.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) { this.repo = repo; }

    public List<CourseDTO> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CourseDTO create(CourseDTO dto) {
        Course c = new Course();
        c.setTitle(dto.getTitle());
        c.setDescription(dto.getDescription());
        c.setInstructorId(dto.getInstructorId());
        Course saved = repo.save(c);
        return toDto(saved);
    }

    public CourseDTO getById(Integer id) {
        Course c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        return toDto(c);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Course", "id", id);
        repo.deleteById(id);
    }

    private CourseDTO toDto(Course c) {
        CourseDTO d = new CourseDTO();
        d.setCourseId(c.getCourseId());
        d.setTitle(c.getTitle());
        d.setDescription(c.getDescription());
        d.setInstructorId(c.getInstructorId());
        return d;
    }
}
