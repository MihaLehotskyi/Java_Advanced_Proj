package ua.lviv.lgs.abit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.abit.dao.AbiturientRepository;
import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.service.AbiturientService;
import ua.lviv.lgs.abit.service.FacultyService;

@Controller
public class AbiturientController {
    @Autowired
    private AbiturientService abiturientService;
    
    @Autowired
    private FacultyService facultyService;



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Abiturient());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Abiturient abiturientForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        abiturientService.save(abiturientForm);


        return "redirect:/home";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	
    	ModelAndView map = new ModelAndView("home");
    	map.addObject("faculty",facultyService.getAll());
        return map;
    }
    @RequestMapping(value ="/create-faculty", method = RequestMethod.GET)
    public String createFaculty() {
    	return "createFaculty";
    }
    
    
}