package com.example.courseenrollment.repository;

import com.example.courseenrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourseId(Long courseId);
    List<Enrollment> findByCourseId(Integer courseId);
}





