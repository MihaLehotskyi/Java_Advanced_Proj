package ua.lviv.lgs.abit.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.domain.MyFaculties;

public interface MyFacultiesRepository extends JpaRepository<MyFaculties, Integer>{
	
}
