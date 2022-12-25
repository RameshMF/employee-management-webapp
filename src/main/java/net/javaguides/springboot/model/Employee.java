package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
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

	@ManyToOne
	@JoinColumn(name = "type")
	private EmployeeTypes type;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "birthdate")
	private String birthdate;

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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "employment_contract_start")
	private String employmentContractStart;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "employment_contract_end")
	private String employmentContractEnd;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport")
	private Passport passport;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="marital_status")
	private MaritalStatus maritalStatus;

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

	public EmployeeTypes getEmployeeTypes() { return type; }

	public void setEmployeeTypes(EmployeeTypes type) { this.type = type; }

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

	public String getBirthdate() { return birthdate; }
	public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

	public String getEmploymentContractStart() { return employmentContractStart; }
	public void setEmploymentContractStart(String employmentContractStart) { this.employmentContractStart = employmentContractStart; }

	public String getEmploymentContractEnd() { return employmentContractEnd; }
	public void setEmploymentContractEnd(String employmentContractEnd) { this.employmentContractEnd = employmentContractEnd; }

	public Passport getPassport() { return passport; }
	public void setPassport(Passport passport) { this.passport = passport; }

	public MaritalStatus getMaritalStatus() { return maritalStatus; }
	public void setMaritalStatus(MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }
}
