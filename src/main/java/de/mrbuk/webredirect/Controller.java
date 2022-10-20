package de.mrbuk.webredirect;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.*;

@RequestMapping("/")
@org.springframework.stereotype.Controller
public class Controller {
    private Collection<Message> messages =
            Collections.synchronizedCollection(new LIFO<>());

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(Model model) {
        model.addAttribute("messages", this.messages);
        model.addAttribute("message", new Message());
        return "message";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String message(@ModelAttribute Message m, Model model) {
        m.setCreated(new Date());
        this.messages.add(m);
        return "redirect:/message";
    }

}
