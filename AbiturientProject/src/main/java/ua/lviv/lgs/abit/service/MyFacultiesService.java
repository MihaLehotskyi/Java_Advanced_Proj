package ua.lviv.lgs.abit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.MyFacultiesRepository;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.domain.MyFaculties;

@Service
public class MyFacultiesService {
	
	@Autowired
	private MyFacultiesRepository myFacultiesRepository;
	
	public List<MyFaculties> getAll(){
		return myFacultiesRepository.findAll();
		
	}
	public void delete(MyFaculties myfaculties) {
		myFacultiesRepository.delete(myfaculties);
	}
	public MyFaculties add(MyFaculties myfaculties) {
		return myFacultiesRepository.save(myfaculties);
	}
	
}
