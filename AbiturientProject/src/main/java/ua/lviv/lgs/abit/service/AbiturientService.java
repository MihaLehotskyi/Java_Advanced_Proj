package ua.lviv.lgs.abit.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.abit.dao.AbiturientRepository;
import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.UserRole;

@Service
public class AbiturientService {
	
		private Logger logger = LoggerFactory.getLogger(AbiturientService.class);
		@Autowired
	    private AbiturientRepository abitRepository;

	    @Autowired
	    private PasswordEncoder bCryptPasswordEncoder;


	    public void save(Abiturient abit) {
	    	logger.info("Login new abiturient : " + abit);
	    	abit.setPassword(bCryptPasswordEncoder.encode(abit.getPassword()));
	    	abit.setPassword(bCryptPasswordEncoder.encode(abit.getPasswordConfirm()));
	    	abit.setRole(UserRole.ROLE_ABITURIENT);
	        abitRepository.save(abit);
	    }
	    
	    public Abiturient findByEmail(String email) {
	    	logger.info("Find abiturient by email : " + email);
	    	return abitRepository.findByEmail(email).get();
	    }
}
