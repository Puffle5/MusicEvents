package blog.controllers;

import blog.entities.Event;
import blog.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    public EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public String displayHomePage(){
        return "index";
    }

    @GetMapping("/showEvents")
    public String displayEvents(Model model) {

        List<Event> events = this.eventRepository.findTop7ByOrderByDateDesc();
        model.addAttribute("events", events);
        return "Events/eventDisplay";
    }
}
