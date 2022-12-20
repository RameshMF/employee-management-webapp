package net.javaguides.springboot.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "line_manager_email")
	private String lineManagerEmail;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="working_position")
	private WorkingPosition workingPosition;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department")
	private Department department;

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

	public String getLineManagerEmail() {
		return lineManagerEmail;
	}

	public void setLineManagerEmail(String lineManagerEmail)
	{
		this.lineManagerEmail = lineManagerEmail;
	}

	public WorkingPosition getWorkingPosition() { return workingPosition; }

	public void setWorkingPosition(WorkingPosition workingPosition) { this.workingPosition = workingPosition; }

	public Department getDepartment() { return department; }
	public String getDepartmentName() {
		return department.getDepartmentName();
	}
	public void setDepartment(Department department) { this.department = department; }
}
