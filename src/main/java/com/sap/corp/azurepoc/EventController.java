package com.sap.corp.azurepoc;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Controller
@RequestMapping(path="/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public @ResponseBody String createEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return String.format("Added %s", event);
    }


    @GetMapping
    public @ResponseBody Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Event> getEvent(@PathVariable Integer id) {
        return Optional.ofNullable(eventRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteEvent(@PathVariable Integer id) {
        eventRepository.deleteById(id);
        return "Deleted " + id;
    }
}