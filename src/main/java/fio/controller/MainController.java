package fio.controller;

import fio.form.PersonForm;
import fio.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class    MainController {
    private static List<Person> persons = new ArrayList<Person>();

    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        model.addAttribute("message", message);
        return modelAndView;
    }
    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public ModelAndView personList(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("personList");
        model.addAttribute("persons", persons);
        return modelAndView;
    }
    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public ModelAndView showAddPersonPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addPerson");
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return modelAndView;
    }

    @PostMapping(value = {"/addPerson"})
    public ModelAndView savePerson(Model model, @Valid @ModelAttribute("personForm") PersonForm personForm, Errors errors)
    {
        ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            modelAndView.setViewName("addPerson");
        }
        else {
            modelAndView.setViewName("personList");
            String firstName = personForm.getFirstName();
            String lastName = personForm.getLastName();
            String street = personForm.getStreet();
            String city = personForm.getCity();
            String zip = personForm.getZip();
            String email = personForm.getEmail();
            Date birthday = personForm.getBirthday();
            Person newPerson = new Person(firstName, lastName, street, city, zip, email, birthday);
            persons.add(newPerson);
            model.addAttribute("persons", persons);
          //  log.info("/addPerson - POST  was called");
            return modelAndView;
        }
        return modelAndView;
    }
}