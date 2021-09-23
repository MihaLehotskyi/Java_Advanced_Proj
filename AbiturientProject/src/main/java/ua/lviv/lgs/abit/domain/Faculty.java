package ua.lviv.lgs.abit.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer maximumplaces;
	@Column
	private Integer minimalpoint;
	
	@Lob
	private String encodedImage;
	
	public Faculty(Integer id, String name, Integer maximumplaces, Integer minimalpoint) {
		this.id = id;
		this.name = name;
		this.maximumplaces = maximumplaces;
		this.minimalpoint = minimalpoint;
	}
	public Faculty() {
	}
	public Faculty(String name, Integer maximumplaces, Integer minimalpoint) {
		super();
		this.name = name;
		this.maximumplaces = maximumplaces;
		this.minimalpoint = minimalpoint;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaximumplaces() {
		return maximumplaces;
	}
	public void setMaximumplaces(Integer maximumplaces) {
		this.maximumplaces = maximumplaces;
	}
	public Integer getMinimalpoint() {
		return minimalpoint;
	}
	public void setMinimalpoint(Integer minimalpoint) {
		this.minimalpoint = minimalpoint;
	}
	
	public String getEncodedImage() {
		return encodedImage;
	}
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, maximumplaces, minimalpoint, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(id, other.id) && Objects.equals(maximumplaces, other.maximumplaces)
				&& Objects.equals(minimalpoint, other.minimalpoint) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", maximumplaces=" + maximumplaces + ", minimalpoint="
				+ minimalpoint + "]";
	}
	
	
}
