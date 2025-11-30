package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.DemoService;

@Controller
public class WebController {

    private final DemoService service;

    public WebController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", service.getItems());
        return "index";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String title) {
        service.addItem(title);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String complete(@PathVariable int id) {
        service.markComplete(id);
        return "redirect:/";
    }
}
