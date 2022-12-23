package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "birthdate")
	private Date birthdate;

	@NotNull
	@Column(name = "line_manager_email")
	private String lineManagerEmail;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="working_position")
	private WorkingPosition workingPosition;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department")
	private Department department;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employment_contract")
	private EmploymentContract employmentContract;

	@NotNull
	@Column(name = "employment_contract_start")
	private Date employmentContractStart;

	@NotNull
	@Column(name = "employment_contract_end")
	private Date employmentContractEnd;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport")
	private Passport passport;

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
	public void setDepartment(Department department) { this.department = department; }

	public EmploymentContract getEmploymentContract() { return employmentContract; }
	public void setEmploymentContract(EmploymentContract employmentContract) { this.employmentContract = employmentContract; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }

	public Date getBirthdate() { return birthdate; }
	public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

	public Date getEmploymentContractStart() { return employmentContractStart; }
	public void setEmploymentContractStart(Date employmentContractStart) { this.employmentContractStart = employmentContractStart; }

	public Date getEmploymentContractEnd() { return employmentContractEnd; }
	public void setEmploymentContractEnd(Date employmentContractEnd) { this.employmentContractEnd = employmentContractEnd; }

	public Passport getPassport() { return passport; }
	public void setPassport(Passport passport) { this.passport = passport; }
}
