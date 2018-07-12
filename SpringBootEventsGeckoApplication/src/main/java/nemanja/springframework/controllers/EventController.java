package nemanja.springframework.controllers;

import nemanja.springframework.domain.Event;
import nemanja.springframework.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

 /*   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listAll(Model model){
        model.addAttribute("events", eventService.listAllEvents());
        return "events"; 
    }*/
    
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("events", eventService.listAllEvents());
        return "events";
    }

    @RequestMapping("event/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("event", eventService.getEventById(id));
        return "eventshow";
    }

    @RequestMapping("event/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("event", eventService.getEventById(id));
        return "eventform";
    }

    @RequestMapping("event/new")
    public String newEvent(Model model){
        model.addAttribute("event", new Event());
        return "eventform";
    }

    @RequestMapping(value = "event", method = RequestMethod.POST)
    public String saveEvent(Event event){
        eventService.saveEvent(event);
        return "redirect:/event/show/" + event.getId();
    }

    @RequestMapping("event/delete/{id}")
    public String delete(@PathVariable Integer id){
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(){
         return "login";
    }

}
