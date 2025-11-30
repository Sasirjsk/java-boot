package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DemoItem;

@Service
public class DemoService {

    private List<DemoItem> items = new ArrayList<>();
    private int idCounter = 1;

    public List<DemoItem> getItems() {
        return items;
    }

    public DemoItem addItem(String title) {
        DemoItem item = new DemoItem(idCounter++, title, false);
        items.add(item);
        return item;
    }

    public boolean markComplete(int id) {
        return items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .map(i -> {
                    i.setCompleted(true);
                    return true;
                }).orElse(false);
    }
}
