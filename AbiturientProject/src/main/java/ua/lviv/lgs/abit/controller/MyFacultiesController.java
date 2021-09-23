package ua.lviv.lgs.abit.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.domain.MyFaculties;
import ua.lviv.lgs.abit.service.AbiturientService;
import ua.lviv.lgs.abit.service.FacultyService;
import ua.lviv.lgs.abit.service.MyFacultiesService;

@Controller
public class MyFacultiesController {
	@Autowired
	private MyFacultiesService myFacultiesService;
	
	@Autowired
	private AbiturientService abiturientService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value ="/myFaculties", method = RequestMethod.GET)
    public ModelAndView getAllItems() {
		 return getMyFacultiesItems();
    }
	
	@RequestMapping(value ="/myFacultie", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String facultyId)  {
		Faculty faculty = facultyService.findById(Integer.parseInt(facultyId));
		
		MyFaculties myFaculties = new MyFaculties();
		myFaculties.setFaculty(faculty);
		myFaculties.setEnteranceDate(new Date());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		Abiturient abiturient = abiturientService.findByEmail(userEmail);
		myFaculties.setAbiturient(abiturient);
		
		List list = new ArrayList<MyFaculties>();
		list = myFacultiesService.getAll();	
		for (int i = 0; i < list.size(); i++) {
			MyFaculties mf = (MyFaculties) list.get(i);
			if(mf.getFaculty().equals(faculty)) {
				return getMyFacultiesItems();
			}
		}
		myFacultiesService.add(myFaculties);
		return getMyFacultiesItems();
    }
	@RequestMapping(value ="/myFacultie", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String id) {
		myFacultiesService.delete(new MyFaculties(Integer.parseInt(id.replaceAll("\\s",""))));
        return getMyFacultiesItems();
    }
	private ModelAndView getMyFacultiesItems() {
		ModelAndView map = new ModelAndView("myFaculties");
    	map.addObject("myFacultiesItems",myFacultiesService.getAll());
        return map;
		
	}
}
