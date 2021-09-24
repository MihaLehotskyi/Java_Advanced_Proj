package ua.lviv.lgs.abit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.MyFacultiesRepository;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.domain.MyFaculties;

@Service
public class MyFacultiesService {
	
	private Logger logger = LoggerFactory.getLogger(MyFacultiesService.class);
	
	@Autowired
	private MyFacultiesRepository myFacultiesRepository;
	
	public List<MyFaculties> getAll(){
		logger.info("Get all my faculties");
		return myFacultiesRepository.findAll();
		
	}
	public void delete(MyFaculties myfaculties) {
		logger.info("Delete  my faculty : "+ myfaculties);
		myFacultiesRepository.delete(myfaculties);
	}
	public MyFaculties add(MyFaculties myfaculties) {
		logger.info("Create  my faculty : "+ myfaculties);
		return myFacultiesRepository.save(myfaculties);
	}
	
}
