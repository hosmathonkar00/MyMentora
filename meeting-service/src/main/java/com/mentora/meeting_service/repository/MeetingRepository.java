package com.mentora.meeting_service.repository;

import com.mentora.meeting_service.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long>
{   List<Meeting> findByMentorId(String mentorId);
}
