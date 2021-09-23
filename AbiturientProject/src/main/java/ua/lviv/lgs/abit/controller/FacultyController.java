package ua.lviv.lgs.abit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.service.FacultyDTOHelper;
import ua.lviv.lgs.abit.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	
	@RequestMapping(value="/addFaculty", method=RequestMethod.POST)
	public ModelAndView createFaculty(@RequestParam MultipartFile image, @RequestParam String name, 
			@RequestParam Integer maximumplaces,@RequestParam Integer minimalpoint) throws IOException{
		facultyService.save(FacultyDTOHelper.createEntity(image, name, maximumplaces, minimalpoint));
		return new ModelAndView("redirect:/home");
		
	}
}
