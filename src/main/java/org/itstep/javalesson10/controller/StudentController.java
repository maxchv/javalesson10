package org.itstep.javalesson10.controller;

import lombok.RequiredArgsConstructor;
import org.itstep.javalesson10.entity.Student;
import org.itstep.javalesson10.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository repository;

    @GetMapping
    String index(@RequestParam(required = false) Integer size,
                 @RequestParam(required = false) Integer page, Model model) {
        model.addAttribute("student", new Student());
        Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 10 : size);
        model.addAttribute("students", repository.findAll(pageable));
        return "student/index";
    }

    @PostMapping
    String save(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/student";
    }


}
