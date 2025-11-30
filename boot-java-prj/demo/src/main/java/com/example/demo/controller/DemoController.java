package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoItem;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DemoItem> getItems() {
        return service.getItems();
    }

    @PostMapping
    public DemoItem addItem(@RequestParam String title) {
        return service.addItem(title);
    }

    @PutMapping("/{id}/complete")
    public String completeItem(@PathVariable int id) {
        return service.markComplete(id) ? "Item marked complete" : "Item not found";
    }
}
