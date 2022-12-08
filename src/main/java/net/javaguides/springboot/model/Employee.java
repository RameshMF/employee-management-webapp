package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="working_position")
	private WorkingPosition workingPosition;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public WorkingPosition getWorkingPosition() { return workingPosition; }

	public void setWorkingPosition(WorkingPosition workingPosition) { this.workingPosition =  workingPosition; }
}
