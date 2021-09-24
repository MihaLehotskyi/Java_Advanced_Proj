package ua.lviv.lgs.abit.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.FacultyRepository;
import ua.lviv.lgs.abit.domain.Faculty;

@Service
public class FacultyService {
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	@Autowired
	private FacultyRepository facultyRepository;
	
	public Faculty save(Faculty faculty) {
		logger.info("Create new faculty : " + faculty);
		return facultyRepository.save(faculty);
	}
	
	public List<Faculty> getAll(){
		logger.info("Get all faculties");
		return facultyRepository.findAll();
	}
	public Faculty findById(Integer id) {
		logger.info("Find faculty by id : " + id);
		return facultyRepository.findById(id).get();
	}
}
