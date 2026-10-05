package com.mentora.meeting_service.controller;

import com.mentora.meeting_service.entity.Meeting;
import com.mentora.meeting_service.service.MeetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting/api")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/add")
    public Meeting addMeeting(@RequestBody Meeting meeting){

        return meetingService.addMeeting(meeting);
    }
    @GetMapping("/all")
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    public Meeting getMeetingById(@PathVariable long id) {
        return meetingService.getMeetingById(id);
    }

    @PutMapping("/update/{id}")
    public Meeting updateMeeting(@PathVariable long id, @RequestBody Meeting meeting) {
        return meetingService.updateMeeting(id, meeting);
    }

    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable long id) {
        meetingService.deleteMetting(id);
    }
    @GetMapping("/mentor/{mentorId}")
    public List<Meeting> getMeetingsByMentorId(@PathVariable String mentorId) {
        return meetingService.getMeetingsByMentorId(mentorId);
    }
}
