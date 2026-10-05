package com.mentora.mentor_service.controller;

import com.mentora.mentor_service.entity.Mentor;
import com.mentora.mentor_service.service.MentoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentors")
public class MentoraController {
    private final MentoraService mentoraService;

    public MentoraController(MentoraService mentoraService) {
        this.mentoraService = mentoraService;
    }
    @PostMapping("/register")
    public Mentor registerMentor(@RequestBody Mentor mentor){
        return mentoraService.registerMentor(mentor);
    }
    @GetMapping("/all")
    public List<Mentor> getAllMentors(){
        return mentoraService.getAllMentors();
    }

}
