package ua.lviv.lgs.abit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.abit.domain.Abiturient;

public interface AbiturientRepository extends JpaRepository<Abiturient, Integer>{
	Optional<Abiturient> findByEmail(String email);
}
