package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Massage;
import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.repository.MassageRepository;
import com.example.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MassageController {

    private final MassageRepository massageRepository;
    private final StudentService studentService;

    @GetMapping("/sendMassage/{id}")
    public String sendMassagePage(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("toId", id);
        return "sendMassage";
    }

    @PostMapping("/sendMassage/forward")
    public String massageForward(@ModelAttribute Massage massage) {
        massageRepository.save(massage);
        return "redirect:/students";
    }

    @GetMapping("/myMassage")
    public String myMassagePage(@RequestParam("Id") int id, ModelMap modelMap) {
        modelMap.addAttribute("massages", massageRepository.findByToId(studentService.getById(id).getId()));
        return "myMassage";
    }
}
