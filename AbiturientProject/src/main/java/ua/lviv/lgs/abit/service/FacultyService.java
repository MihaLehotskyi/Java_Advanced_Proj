package ua.lviv.lgs.abit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.FacultyRepository;
import ua.lviv.lgs.abit.domain.Faculty;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;
	
	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
	
	public List<Faculty> getAll(){
		return facultyRepository.findAll();
	}
	
}
