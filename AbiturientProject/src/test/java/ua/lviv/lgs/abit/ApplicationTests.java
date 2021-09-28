package ua.lviv.lgs.abit;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.abit.dao.AbiturientRepository;
import ua.lviv.lgs.abit.dao.FacultyRepository;
import ua.lviv.lgs.abit.dao.MyFacultiesRepository;
import ua.lviv.lgs.abit.domain.Abiturient;
import ua.lviv.lgs.abit.domain.Faculty;
import ua.lviv.lgs.abit.domain.MyFaculties;
import ua.lviv.lgs.abit.domain.Subject;
import ua.lviv.lgs.abit.domain.UserRole;
import ua.lviv.lgs.abit.service.AbiturientService;
import ua.lviv.lgs.abit.service.FacultyService;
import ua.lviv.lgs.abit.service.MyFacultiesService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private AbiturientService abiturientService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private MyFacultiesService myFacultiesService;

	@Autowired
	private AbiturientRepository abiturientRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private MyFacultiesRepository myFacultiesRepository;

	@Test
	public void testSaveUser() {
		List<Abiturient> abiturients = abiturientRepository.findAll();
		assertThat(abiturients, hasSize(0));

		Abiturient abiturient = new Abiturient();
		abiturient.setFirstname("1");
		abiturient.setSecondname("1");
		abiturient.setEmail("1@gmail.com");
		abiturient.setPassword("1");
		abiturient.setPasswordConfirm("1");
		abiturient.setRole(UserRole.ROLE_ABITURIENT);
		Date now = new Date(100);
		abiturient.setDateOfBirth(now);
		abiturient.setFirstsubject(Subject.English);
		abiturient.setFirstsubjectpoint(1);
		abiturient.setSecondsubject(Subject.Geography);
		abiturient.setSecondsubjectpoint(1);
		abiturient.setThirdsubject(Subject.Mathematics);
		abiturient.setThirdsubjectpoint(1);

		abiturientService.save(abiturient);

		abiturients = abiturientRepository.findAll();
		assertThat(abiturients, hasSize(1));

		Abiturient abiturientFromDb = abiturients.get(0);
		assertTrue(abiturientFromDb.getFirstname().equals(abiturient.getFirstname()));
		assertTrue(abiturientFromDb.getSecondname().equals(abiturient.getSecondname()));
		assertTrue(abiturientFromDb.getEmail().equals(abiturient.getEmail()));
		assertTrue(abiturientFromDb.getRole().equals(abiturient.getRole()));
		assertTrue(abiturientFromDb.getDateOfBirth().equals(abiturient.getDateOfBirth()));
		assertTrue(abiturientFromDb.getFirstsubject().equals(abiturient.getFirstsubject()));
		assertTrue(abiturientFromDb.getFirstsubjectpoint().equals(abiturient.getFirstsubjectpoint()));
		assertTrue(abiturientFromDb.getSecondsubject().equals(abiturient.getSecondsubject()));
		assertTrue(abiturientFromDb.getSecondsubjectpoint().equals(abiturient.getSecondsubjectpoint()));
		assertTrue(abiturientFromDb.getThirdsubject().equals(abiturient.getThirdsubject()));
		assertTrue(abiturientFromDb.getThirdsubjectpoint().equals(abiturient.getThirdsubjectpoint()));
	}

	@Test
	public void testFindByEmail() {
		List<Abiturient> abiturients = abiturientRepository.findAll();
		assertThat(abiturients, hasSize(0));

		Abiturient abiturient = new Abiturient();
		abiturient.setFirstname("1");
		abiturient.setSecondname("1");
		abiturient.setEmail("1@gmail.com");
		abiturient.setPassword("1");
		abiturient.setPasswordConfirm("1");
		abiturient.setRole(UserRole.ROLE_ABITURIENT);
		Date now = new Date(100);
		abiturient.setDateOfBirth(now);
		abiturient.setFirstsubject(Subject.English);
		abiturient.setFirstsubjectpoint(1);
		abiturient.setSecondsubject(Subject.Geography);
		abiturient.setSecondsubjectpoint(1);
		abiturient.setThirdsubject(Subject.Mathematics);
		abiturient.setThirdsubjectpoint(1);

		abiturientRepository.save(abiturient);

		abiturients = abiturientRepository.findAll();
		assertThat(abiturients, hasSize(1));

		Abiturient findByEmail = abiturientService.findByEmail(abiturient.getEmail());

		assertTrue(findByEmail.getFirstname().equals(abiturient.getFirstname()));
		assertTrue(findByEmail.getSecondname().equals(abiturient.getSecondname()));
		assertTrue(findByEmail.getEmail().equals(abiturient.getEmail()));
		assertTrue(findByEmail.getRole().equals(abiturient.getRole()));
		assertTrue(findByEmail.getDateOfBirth().equals(abiturient.getDateOfBirth()));
		assertTrue(findByEmail.getFirstsubject().equals(abiturient.getFirstsubject()));
		assertTrue(findByEmail.getFirstsubjectpoint().equals(abiturient.getFirstsubjectpoint()));
		assertTrue(findByEmail.getSecondsubject().equals(abiturient.getSecondsubject()));
		assertTrue(findByEmail.getSecondsubjectpoint().equals(abiturient.getSecondsubjectpoint()));
		assertTrue(findByEmail.getThirdsubject().equals(abiturient.getThirdsubject()));
		assertTrue(findByEmail.getThirdsubjectpoint().equals(abiturient.getThirdsubjectpoint()));
	}
	
	@Test
	public void testSavePeriodical() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);

		facultyService.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyFromDb = faculties.get(0);
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getMaximumplaces().equals(faculty.getMaximumplaces()));
		assertTrue(facultyFromDb.getEncodedImage().equals(faculty.getEncodedImage()));
		assertTrue(facultyFromDb.getMinimalpoint().equals(faculty.getMinimalpoint()));
	}
	
	@Test
	public void testFindById() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);

		facultyService.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));

		Faculty facultyFromDb = facultyService.findById(faculties.get(0).getId());

		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getMaximumplaces().equals(faculty.getMaximumplaces()));
		assertTrue(facultyFromDb.getEncodedImage().equals(faculty.getEncodedImage()));
		assertTrue(facultyFromDb.getMinimalpoint().equals(faculty.getMinimalpoint()));
	}
	
	@Test
	public void testGetAllPeriodicals() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);

		Faculty faculty2 = new Faculty();
		faculty2.setName("12");
		faculty2.setMaximumplaces(12);
		faculty2.setEncodedImage("12");
		faculty2.setMinimalpoint(12);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(2));

		List<Faculty> facultiesFromDb = facultyService.getAll();

		assertTrue(facultiesFromDb.get(0).getName().equals(faculty.getName()));
		assertTrue(facultiesFromDb.get(0).getMaximumplaces().equals(faculty.getMaximumplaces()));
		assertTrue(facultiesFromDb.get(0).getEncodedImage().equals(faculty.getEncodedImage()));
		assertTrue(facultiesFromDb.get(0).getMinimalpoint().equals(faculty.getMinimalpoint()));

		assertTrue(facultiesFromDb.get(1).getName().equals(faculty2.getName()));
		assertTrue(facultiesFromDb.get(1).getMaximumplaces().equals(faculty2.getMaximumplaces()));
		assertTrue(facultiesFromDb.get(1).getEncodedImage().equals(faculty2.getEncodedImage()));
		assertTrue(facultiesFromDb.get(1).getMinimalpoint().equals(faculty2.getMinimalpoint()));
	}
	
	@Test
	public void testAddToBucket() {
		Abiturient abiturient = new Abiturient();
		abiturient.setFirstname("1");
		abiturient.setSecondname("1");
		abiturient.setEmail("1@gmail.com");
		abiturient.setPassword("1");
		abiturient.setPasswordConfirm("1");
		abiturient.setRole(UserRole.ROLE_ABITURIENT);
		Date now = new Date(100);
		abiturient.setDateOfBirth(now);
		abiturient.setFirstsubject(Subject.English);
		abiturient.setFirstsubjectpoint(1);
		abiturient.setSecondsubject(Subject.Geography);
		abiturient.setSecondsubjectpoint(1);
		abiturient.setThirdsubject(Subject.Mathematics);
		abiturient.setThirdsubjectpoint(1);


		abiturientService.save(abiturient);

		Abiturient abiturientFromDb = abiturientRepository.findAll().stream().findFirst().get();

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);

		facultyService.save(faculty);

		Faculty facultyFromDb = facultyRepository.findAll().stream().findFirst().get();

		Date now1 = new Date();
		MyFaculties myFaculty = new MyFaculties();
		myFaculty.setFaculty(facultyFromDb);
		myFaculty.setAbiturient(abiturientFromDb);
		myFaculty.setEnteranceDate(now1);

		List<MyFaculties> myFaculties = myFacultiesRepository.findAll();
		assertThat(myFaculties, hasSize(0));

		myFacultiesService.add(myFaculty);

		myFaculties = myFacultiesRepository.findAll();
		assertThat(myFaculties, hasSize(1));

		MyFaculties myFacultiesFromDb = myFaculties.get(0);

		assertTrue(myFacultiesFromDb.getFaculty().equals(facultyFromDb));
		assertTrue(myFacultiesFromDb.getAbiturient().equals(abiturientFromDb));
		assertTrue(myFacultiesFromDb.getEnteranceDate().equals(now1));
	}
	
	@Test
	public void testDeleteFromBucket() {
		Abiturient abiturient = new Abiturient();
		abiturient.setFirstname("1");
		abiturient.setSecondname("1");
		abiturient.setEmail("1@gmail.com");
		abiturient.setPassword("1");
		abiturient.setPasswordConfirm("1");
		abiturient.setRole(UserRole.ROLE_ABITURIENT);
		Date now = new Date(100);
		abiturient.setDateOfBirth(now);
		abiturient.setFirstsubject(Subject.English);
		abiturient.setFirstsubjectpoint(1);
		abiturient.setSecondsubject(Subject.Geography);
		abiturient.setSecondsubjectpoint(1);
		abiturient.setThirdsubject(Subject.Mathematics);
		abiturient.setThirdsubjectpoint(1);

		abiturientService.save(abiturient);

		Abiturient abiturientFromDb = abiturientRepository.findAll().stream().findFirst().get();

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("2");
		faculty2.setMaximumplaces(2);
		faculty2.setEncodedImage("2");
		faculty2.setMinimalpoint(2);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> facultiesFromDb = facultyRepository.findAll();

		Date now1 = new Date();
		MyFaculties myFaculty = new MyFaculties();
		myFaculty.setFaculty(facultiesFromDb.get(0));
		myFaculty.setAbiturient(abiturientFromDb);
		myFaculty.setEnteranceDate(now1);

		MyFaculties myFaculty1 = new MyFaculties();
		myFaculty1.setFaculty(facultiesFromDb.get(1));
		myFaculty1.setAbiturient(abiturientFromDb);
		myFaculty1.setEnteranceDate(now1);

		List<MyFaculties> MyFaculties = myFacultiesRepository.findAll();
		assertThat(MyFaculties, hasSize(0));

		myFacultiesRepository.saveAll(Arrays.asList(myFaculty, myFaculty1));

		MyFaculties = myFacultiesRepository.findAll();
		assertThat(MyFaculties, hasSize(2));

		myFacultiesService.delete(MyFaculties.get(0));

		MyFaculties = myFacultiesRepository.findAll();
		assertThat(MyFaculties, hasSize(1));
	}
	
	@Test
	public void testGetAll() {
		Abiturient abiturient = new Abiturient();
		abiturient.setFirstname("1");
		abiturient.setSecondname("1");
		abiturient.setEmail("1@gmail.com");
		abiturient.setPassword("1");
		abiturient.setPasswordConfirm("1");
		abiturient.setRole(UserRole.ROLE_ABITURIENT);
		Date now = new Date(100);
		abiturient.setDateOfBirth(now);
		abiturient.setFirstsubject(Subject.English);
		abiturient.setFirstsubjectpoint(1);
		abiturient.setSecondsubject(Subject.Geography);
		abiturient.setSecondsubjectpoint(1);
		abiturient.setThirdsubject(Subject.Mathematics);
		abiturient.setThirdsubjectpoint(1);

		abiturientService.save(abiturient);

		Abiturient abiturientFromDb = abiturientRepository.findAll().stream().findFirst().get();

		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("1");
		faculty.setMaximumplaces(1);
		faculty.setEncodedImage("1");
		faculty.setMinimalpoint(1);
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("2");
		faculty2.setMaximumplaces(2);
		faculty2.setEncodedImage("2");
		faculty2.setMinimalpoint(2);

		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> facultiesFromDb = facultyRepository.findAll();

		Date now1 = new Date();
		MyFaculties myFaculty = new MyFaculties();
		myFaculty.setFaculty(facultiesFromDb.get(0));
		myFaculty.setAbiturient(abiturientFromDb);
		myFaculty.setEnteranceDate(now1);

		MyFaculties myFaculty2 = new MyFaculties();
		myFaculty2.setFaculty(facultiesFromDb.get(1));
		myFaculty2.setAbiturient(abiturientFromDb);
		myFaculty2.setEnteranceDate(now1);

		List<MyFaculties> myFaculties = myFacultiesRepository.findAll();
		assertThat(myFaculties, hasSize(0));

		myFacultiesRepository.saveAll(Arrays.asList(myFaculty, myFaculty2));

		List<MyFaculties> myFacultiesFromDb = myFacultiesService.getAll();
		assertThat(myFacultiesFromDb, hasSize(2));
	}
	
}