package com.mentora.mentor_service.service;

import com.mentora.mentor_service.entity.Mentor;
import com.mentora.mentor_service.repository.MentorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MentoraService {
    private final MentorRepository mentorRepository;

    public MentoraService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
    public Mentor registerMentor(Mentor mentor){
        return mentorRepository.save(mentor);
    }
    public List<Mentor> getAllMentors(){
        return mentorRepository.findAll();
    }
}
