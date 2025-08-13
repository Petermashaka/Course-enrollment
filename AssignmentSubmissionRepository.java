package com.example.newproject.repository;

import com.example.newproject.model.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Integer> {
}
