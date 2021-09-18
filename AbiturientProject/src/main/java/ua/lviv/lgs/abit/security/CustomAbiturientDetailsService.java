package ua.lviv.lgs.abit.security;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import ua.lviv.lgs.abit.dao.AbiturientRepository;
import ua.lviv.lgs.abit.domain.Abiturient;
@Service("customAbiturientDetailsService")
public class CustomAbiturientDetailsService implements UserDetailsService{

	@Autowired
	private AbiturientRepository abiturientRepository; 

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Abiturient> abit = abiturientRepository.findByEmail(email);
		if(abit.isPresent()) {
			Abiturient abiturient = abit.get();
			return new CustomAbiturientDetails(abiturient, Collections.singletonList(abiturient.getRole().toString()));
			}
		throw new UsernameNotFoundException("No such Abiturient present!");
	}
	

	

}
