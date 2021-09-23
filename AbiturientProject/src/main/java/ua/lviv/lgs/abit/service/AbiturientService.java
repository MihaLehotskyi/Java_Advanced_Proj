package ua.lviv.lgs.abit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.AbiturientRepository;
import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.UserRole;

@Service
public class AbiturientService {
		@Autowired
	    private AbiturientRepository abitRepository;

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;


	    public void save(Abiturient abit) {
	    	abit.setPassword(bCryptPasswordEncoder.encode(abit.getPassword()));
	    	abit.setPassword(bCryptPasswordEncoder.encode(abit.getPasswordConfirm()));
	    	abit.setRole(UserRole.ROLE_ABITURIENT);
	        abitRepository.save(abit);
	    }
	    
	    public Abiturient findByEmail(String email) {
	    	return abitRepository.findByEmail(email).get();
	    }
}
