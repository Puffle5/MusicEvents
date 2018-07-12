package blog.controllers;

import blog.bindingModels.EventSearch;
import blog.entities.Event;
import blog.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/searchEvents")
    public String searchEvent(EventSearch eventSearch, Model model) {
        List<Event> allEvents = this.eventRepository.findAll();
        List<Event> events = new ArrayList<>();
        for (Event event : allEvents) {
            if (match(event, eventSearch.getEvent())) {
                events.add(event);
            }
        }
        model.addAttribute("events", events);
        return "Events/eventDisplay";
    }
    private static boolean match(Event event, String eventData) {
        eventData = eventData.toLowerCase();
        if (event.getDate().toString().toLowerCase().contains(eventData)) {
            return true;
        } else if (event.getPerformer().getName().toLowerCase().contains(eventData)) {
            return true;
        } else if (event.getPlace().toLowerCase().contains(eventData)) {
            return true;
        } else if (event.getCity().toLowerCase().contains(eventData)) {
            return true;
        }
        return false;
    }
}
