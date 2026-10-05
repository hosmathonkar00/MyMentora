package com.mentora.mentor_service.repository;

import com.mentora.mentor_service.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

    Optional<Mentor> findByEmail(String email);
}
