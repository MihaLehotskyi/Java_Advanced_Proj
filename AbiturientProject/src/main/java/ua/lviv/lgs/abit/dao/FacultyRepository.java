package ua.lviv.lgs.abit.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.abit.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
