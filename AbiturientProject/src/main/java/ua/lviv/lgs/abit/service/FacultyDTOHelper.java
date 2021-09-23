package ua.lviv.lgs.abit.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.abit.domain.Faculty;

public class FacultyDTOHelper {

		public static Faculty createEntity(MultipartFile image,  String name, Integer maximumplaces, Integer minimalpoint) throws IOException {
			Faculty faculty = new Faculty();
			faculty.setName(name);
			faculty.setMaximumplaces(maximumplaces);
			faculty.setMinimalpoint(minimalpoint);
			faculty.setEncodedImage(Base64.getEncoder().encodeToString(image.getBytes()));
			return faculty;
			
		}
}
