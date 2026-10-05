package com.mentora.meeting_service.service;

import com.mentora.meeting_service.entity.Meeting;
import com.mentora.meeting_service.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

        public Meeting addMeeting(Meeting meeting){
            return meetingRepository.save(meeting);
        }

        public List<Meeting> getAllMeetings(){
            return meetingRepository.findAll();
        }

        public Meeting getMeetingById(Long id){
            return meetingRepository.findById(id).orElse(null);
        }

        public Meeting updateMeeting(Long id,Meeting meeting){
            Meeting existingMeeting = meetingRepository.findById(id).orElse(null);
            if(existingMeeting == null){
                return null;
            }
            existingMeeting.setTitle(meeting.getTitle());
            existingMeeting.setDescription(meeting.getDescription());
            existingMeeting.setDate(meeting.getDate());
            existingMeeting.setStartTime(meeting.getStartTime());
            existingMeeting.setEndTime(meeting.getEndTime());
            existingMeeting.setMentorId(meeting.getMentorId());
            return meetingRepository.save(existingMeeting);
        }
        public void deleteMetting(Long id){
            meetingRepository.deleteById(id);
        }

    public List<Meeting> getMeetingsByMentorId(String mentorId) {
        return meetingRepository.findByMentorId(mentorId);
    }
}
