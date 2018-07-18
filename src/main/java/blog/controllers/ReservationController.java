package blog.controllers;

import blog.bindingModels.ReservationBindingModel;
import blog.entities.Event;
import blog.entities.Reservation;
import blog.repositories.EventRepository;
import blog.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReservationController {
    public ReservationRepository reservationRepository;
    public EventRepository eventRepository;

    @Autowired
    public ReservationController(EventRepository eventRepository, ReservationRepository reservationRepository) {
        this.reservationRepository=reservationRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/reservationForm")
    public String getReservationPage(Model model) {
        List<Event> events = this.eventRepository.findAll();
        model.addAttribute("events", events);
        return "Reservations/reservation-form";
    }

    @PostMapping("/reservationRegister")
    public String registerProcess(ReservationBindingModel reservationBindingModel) {
        Event event=this.eventRepository.findOne(reservationBindingModel.getEventId());
        Reservation reservation=new Reservation(reservationBindingModel.getUserName()
                , reservationBindingModel.getEmail()
                , reservationBindingModel.getPhone()
                , reservationBindingModel.getTicketCount());
//        reservation.setEvent(t);


        this.reservationRepository.saveAndFlush(reservation);
        return "redirect:/showEvents";
    }

}
