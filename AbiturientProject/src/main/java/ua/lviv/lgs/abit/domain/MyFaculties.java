package ua.lviv.lgs.abit.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "myFaculties")
public class MyFaculties {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "abiturient_id", referencedColumnName = "id")
	private Abiturient abiturient;
	
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;
	
	@Column(name = "enterance_date")
	private Date enteranceDate;

	public MyFaculties(Integer id, Abiturient abiturient, Faculty faculty, Date enteranceDate) {
		super();
		this.id = id;
		this.abiturient = abiturient;
		this.faculty = faculty;
		this.enteranceDate = enteranceDate;
	}

	public MyFaculties(Abiturient abiturient, Faculty faculty, Date purchaseDate) {
		super();
		this.abiturient = abiturient;
		this.faculty = faculty;
		this.enteranceDate = purchaseDate;
	}

	public MyFaculties() {
		
	}

	public MyFaculties(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Abiturient getAbiturient() {
		return abiturient;
	}

	public void setAbiturient(Abiturient abiturient) {
		this.abiturient = abiturient;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Date getEnteranceDate() {
		return enteranceDate;
	}

	public void setEnteranceDate(Date enteranceDate) {
		this.enteranceDate = enteranceDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abiturient, faculty, id, enteranceDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyFaculties other = (MyFaculties) obj;
		return Objects.equals(abiturient, other.abiturient) && Objects.equals(faculty, other.faculty)
				&& Objects.equals(id, other.id) && Objects.equals(enteranceDate, other.enteranceDate);
	}

	@Override
	public String toString() {
		return "MyFaculties [id=" + id + ", abiturient=" + abiturient + ", faculty=" + faculty + ", purchaseDate="
				+ enteranceDate + "]";
	}
	
	
}
