package ua.lviv.lgs.abit.domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abiturient")
public class Abiturient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String secondname;
	private String email;
	private String password;
	private String passwordConfirm;
	private Date dateOfBirth;
	private Subject firstsubject;
	private Integer firstsubjectpoint;
	private Subject secondsubject;
	private Integer secondsubjectpoint;
	private Subject thirdsubject;
	private Integer thirdsubjectpoint;
	
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	
	public Abiturient(Abiturient abit) {
		this.id = abit.id;
		this.firstname = abit.firstname;
		this.secondname = abit.secondname;
		this.email = abit.email;
		this.passwordConfirm = abit.passwordConfirm;
		this.password = abit.password;
		this.dateOfBirth = abit.dateOfBirth;
		this.firstsubject = abit.firstsubject;
		this.firstsubjectpoint = abit.firstsubjectpoint;
		this.secondsubject = abit.secondsubject;
		this.secondsubjectpoint = abit.secondsubjectpoint;
		this.thirdsubject = abit.thirdsubject;
		this.thirdsubjectpoint = abit.thirdsubjectpoint;
		this.role = abit.role;
	}
	public Abiturient(Integer id, String firstname, String secondname, String email, String password,String passwordConfirm, Date dateOfBirth,
			Subject firstsubject, Integer firstsubjectpoint, Subject secondsubject, Integer secondsubjectpoint,
			Subject thirdsubject, Integer thirdsubjectpoint, UserRole role) {
	
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.dateOfBirth = dateOfBirth;
		this.firstsubject = firstsubject;
		this.firstsubjectpoint = firstsubjectpoint;
		this.secondsubject = secondsubject;
		this.secondsubjectpoint = secondsubjectpoint;
		this.thirdsubject = thirdsubject;
		this.thirdsubjectpoint = thirdsubjectpoint;
		this.role = role;
	}
	public Abiturient(String firstname, String secondname, String email, String password,String passwordConfirm, Date dateOfBirth,
			Subject firstsubject, Integer firstsubjectpoint, Subject secondsubject, Integer secondsubjectpoint,
			Subject thirdsubject, Integer thirdsubjectpoint, UserRole role) {
		
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.dateOfBirth = dateOfBirth;
		this.firstsubject = firstsubject;
		this.firstsubjectpoint = firstsubjectpoint;
		this.secondsubject = secondsubject;
		this.secondsubjectpoint = secondsubjectpoint;
		this.thirdsubject = thirdsubject;
		this.thirdsubjectpoint = thirdsubjectpoint;
		this.role = role;
	}
	public Abiturient() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Subject getFirstsubject() {
		return firstsubject;
	}
	public void setFirstsubject(Subject firstsubject) {
		this.firstsubject = firstsubject;
	}
	public Integer getFirstsubjectpoint() {
		return firstsubjectpoint;
	}
	public void setFirstsubjectpoint(Integer firstsubjectpoint) {
		this.firstsubjectpoint = firstsubjectpoint;
	}
	public Subject getSecondsubject() {
		return secondsubject;
	}
	public void setSecondsubject(Subject secondsubject) {
		this.secondsubject = secondsubject;
	}
	public Integer getSecondsubjectpoint() {
		return secondsubjectpoint;
	}
	public void setSecondsubjectpoint(Integer secondsubjectpoint) {
		this.secondsubjectpoint = secondsubjectpoint;
	}
	public Subject getThirdsubject() {
		return thirdsubject;
	}
	public void setThirdsubject(Subject thirdsubject) {
		this.thirdsubject = thirdsubject;
	}
	public Integer getThirdsubjectpoint() {
		return thirdsubjectpoint;
	}
	public void setThirdsubjectpoint(Integer thirdsubjectpoint) {
		this.thirdsubjectpoint = thirdsubjectpoint;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, email, firstname, firstsubject, firstsubjectpoint, id, password,
				passwordConfirm, role, secondname, secondsubject, secondsubjectpoint, thirdsubject, thirdsubjectpoint);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abiturient other = (Abiturient) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && firstsubject == other.firstsubject
				&& Objects.equals(firstsubjectpoint, other.firstsubjectpoint) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(passwordConfirm, other.passwordConfirm)
				&& role == other.role && Objects.equals(secondname, other.secondname)
				&& secondsubject == other.secondsubject && Objects.equals(secondsubjectpoint, other.secondsubjectpoint)
				&& thirdsubject == other.thirdsubject && Objects.equals(thirdsubjectpoint, other.thirdsubjectpoint);
	}
	@Override
	public String toString() {
		return "Abiturient [id=" + id + ", firstname=" + firstname + ", secondname=" + secondname + ", email=" + email
				+ ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", dateOfBirth=" + dateOfBirth
				+ ", firstsubject=" + firstsubject + ", firstsubjectpoint=" + firstsubjectpoint + ", secondsubject="
				+ secondsubject + ", secondsubjectpoint=" + secondsubjectpoint + ", thirdsubject=" + thirdsubject
				+ ", thirdsubjectpoint=" + thirdsubjectpoint + ", role=" + role + "]";
	}
	
	
	
}
