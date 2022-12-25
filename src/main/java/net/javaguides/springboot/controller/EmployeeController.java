package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

	@Autowired
	private ItemStorageService<Employee> employeeService;

	@Autowired
	private ItemStorageService<Department> departmentService;

	@Autowired
	private ItemStorageService<WorkingPosition> workingPositionService;

	@Autowired
	private EmploymentContractService employmentContractService;

	@Autowired
	private MaritalStatusService maritalStatusService;

	@Autowired
	private EmployeeTypesService employeeTypesService;

	@Autowired
	private ItemStorageService<FamilyMember> familyMemberService;

	@Autowired
	private ItemStorageService<KinshipDegree> kinshipDegreeService;

	@Autowired
	private ItemStorageService<Education> educationService;

	@Autowired
	private FormOfStudyService formOfStudyService;

	// display list of all  employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}


	// education
	@GetMapping("/education")
	public String education(Model model) {
		return findPaginatedEducation(1,"educationalInstitution", "asc", model);
	}

	@GetMapping("/showNewEducationForm")
	public String showNewEducationForm(Model model) {
		List<Employee> listEmployees = this.employeeService.getAllItems();
		List<FormOfStudy> listFormsOfStudy = this.formOfStudyService.getAllFormsOfStudy();

		Education education = new Education();

		// create model attribute to bind form data
		model.addAttribute("education", education);
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("listFormsOfStudy", listFormsOfStudy);
		return "new_education";
	}

	@PostMapping("/saveEducation")
	public String saveEducation(@ModelAttribute("education") Education education) {
		// save education to database
		educationService.saveItem(education);
		return "redirect:/education";
	}

	@GetMapping("/deleteEducation/{id}")
	public String deleteEducation(@PathVariable (value = "id") long id) {

		// call delete employment contract method
		this.educationService.deleteItemById(id);
		return "redirect:/education";
	}

	// family members
	@GetMapping("/familyMembers")
	public String familyMembers(Model model) {
		return findPaginatedFamilyMembers(1,"firstName", "asc", model);
	}

	@GetMapping("/showNewFamilyMemberForm")
	public String showNewFamilyMemberForm(Model model) {
		List<Employee> listEmployees = this.employeeService.getAllItems();
		List<KinshipDegree> listKinshipDegree = this.kinshipDegreeService.getAllItems();

		// create model attribute to bind form data
		FamilyMember familyMember = new FamilyMember();
		model.addAttribute("familyMember", familyMember);
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("listKinshipDegree", listKinshipDegree);
		return "new_family_member";
	}

	@PostMapping("/saveFamilyMember")
	public String saveFamilyMember(@ModelAttribute("familyMember") FamilyMember familyMember) {

		// save employment contract to database
		familyMemberService.saveItem(familyMember);
		return "redirect:/familyMembers";
	}

	@GetMapping("/deleteFamilyMember/{id}")
	public String deleteFamilyMember(@PathVariable (value = "id") long id) {

		// call delete employment contract method
		this.familyMemberService.deleteItemById(id);
		return "redirect:/familyMembers";
	}

	// employment contracts
	@GetMapping("/employmentContracts")
	public String employmentContracts(Model model) {
		return findPaginatedEmploymentContracts(1,"employmentContractName", "asc", model);
	}

	@GetMapping("/showNewEmploymentContractForm")
	public String showNewEmploymentContractForm(Model model) {
		// create model attribute to bind form data
		EmploymentContract employmentContract = new EmploymentContract();
		model.addAttribute("employmentContract", employmentContract);
		return "new_employment_contract";
	}

	@PostMapping("/saveEmploymentContract")
	public String saveEmploymentContract(@ModelAttribute("employmentContract") EmploymentContract employmentContract) {
		// save employment contract to database
		employmentContractService.saveEmploymentContract(employmentContract);
		return "redirect:/employmentContracts";
	}

	@GetMapping("/showFormForUpdateEmploymentContract/{id}")
	public String showFormForUpdateEmploymentContract(@PathVariable ( value = "id") long id, Model model) {

		// get employment contract from the service
		EmploymentContract employmentContract = employmentContractService.getEmploymentContractById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employmentContract", employmentContract);
		return "update_employment_contract";
	}

	@GetMapping("/deleteEmploymentContract/{id}")
	public String deleteEmploymentContract(@PathVariable (value = "id") long id) {

		// call delete employment contract method
		this.employmentContractService.deleteEmploymentContractById(id);
		return "redirect:/employmentContracts";
	}

	// working positions
	@GetMapping("/workingPositions")
	public String workingPositions(Model model) {
		return findPaginatedWorkingPositions(1,"positionName", "asc", model);
	}

	@GetMapping("/showNewWorkingPositionForm")
	public String showNewWorkingPositionForm(Model model) {
		// create model attribute to bind form data
		WorkingPosition workingPosition = new WorkingPosition();
		model.addAttribute("workingPosition", workingPosition);
		return "new_working_position";
	}

	@PostMapping("/saveWorkingPosition")
	public String saveWorkingPosition(@ModelAttribute("workingPosition") WorkingPosition workingPosition) {
		// save working position to database
		workingPositionService.saveItem(workingPosition);
		return "redirect:/workingPositions";
	}

	@GetMapping("/showFormForUpdateWorkingPosition/{id}")
	public String showFormForUpdateWorkingPosition(@PathVariable ( value = "id") long id, Model model) {

		// get working position from the service
		WorkingPosition workingPosition = workingPositionService.getItemById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("workingPosition", workingPosition);
		return "update_working_position";
	}

	@GetMapping("/deleteWorkingPosition/{id}")
	public String deleteWorkingPosition(@PathVariable (value = "id") long id) {

		// call delete working position method
		this.workingPositionService.deleteItemById(id);
		return "redirect:/workingPositions";
	}

	// departments
	@GetMapping("/departments")
	public String departments(Model model) {
		return findPaginatedDepartments(1,"departmentName", "asc", model);
	}

	@GetMapping("/showNewDepartmentForm")
	public String showNewDepartmentForm(Model model) {
		// create model attribute to bind form data
		Department department = new Department();
		model.addAttribute("department", department);
		return "new_department";
	}

	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("department") Department department) {
		// save department to database
 		departmentService.saveItem(department);
		return "redirect:/departments";
	}

	@GetMapping("/showFormForUpdateDepartment/{id}")
	public String showFormForUpdateDepartment(@PathVariable ( value = "id") long id, Model model) {

		// get department from the service
		Department department = departmentService.getItemById(id);

		// set department as a model attribute to pre-populate the form
		model.addAttribute("department", department);
		return "update_department";
	}

	@GetMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable (value = "id") long id) {

		// call delete department method
		this.departmentService.deleteItemById(id);
		return "redirect:/departments";
	}

	// employees
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		List<Employee> listEmployees = this.employeeService.getAllItems();
		List<WorkingPosition> workingPositions = this.workingPositionService.getAllItems();
		List<Department> departments = this.departmentService.getAllItems();
		List<EmploymentContract> listEmploymentContracts = this.employmentContractService.getAllEmploymentContracts();
		List<MaritalStatus> listMaritalStatus = this.maritalStatusService.getAllMaritalStatus();
		List<EmployeeTypes> listEmployeeTypes = this.employeeTypesService.getAllEmployeeTypes();
		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		model.addAttribute("departments", departments);
		model.addAttribute("workingPositions", workingPositions);
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("listEmploymentContracts", listEmploymentContracts);
		model.addAttribute("listMaritalStatus", listMaritalStatus);
		model.addAttribute("listEmployeeTypes", listEmployeeTypes);

		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveItem(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Employee employee = employeeService.getItemById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.employeeService.deleteItemById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@GetMapping("/departments/page/{pageNo}")
	public String findPaginatedDepartments(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 5;

		Page<Department> page = departmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Department> listDepartments = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listDepartments", listDepartments);
		return "departments";
	}

	@GetMapping("/workingPositions/page/{pageNo}")
	public String findPaginatedWorkingPositions(@PathVariable (value = "pageNo") int pageNo,
										   @RequestParam("sortField") String sortField,
										   @RequestParam("sortDir") String sortDir,
										   Model model) {
		int pageSize = 5;

		Page<WorkingPosition> page = workingPositionService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<WorkingPosition> listWorkingPositions = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listWorkingPositions", listWorkingPositions);
		return "working_positions";
	}

	@GetMapping("/employmentContracts/page/{pageNo}")
	public String findPaginatedEmploymentContracts(@PathVariable (value = "pageNo") int pageNo,
												@RequestParam("sortField") String sortField,
												@RequestParam("sortDir") String sortDir,
												Model model) {
		int pageSize = 5;

		Page<EmploymentContract> page = employmentContractService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<EmploymentContract> listEmploymentContracts = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmploymentContracts", listEmploymentContracts);
		return "employment_contracts";
	}

	@GetMapping("/familyMembers/page/{pageNo}")
	public String findPaginatedFamilyMembers(@PathVariable (value = "pageNo") int pageNo,
										   @RequestParam("sortField") String sortField,
										   @RequestParam("sortDir") String sortDir,
										   Model model) {
		int pageSize = 5;

		Page<FamilyMember> page = familyMemberService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<FamilyMember> listFamilyMembers = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listFamilyMembers", listFamilyMembers);
		return "family_members";
	}

	@GetMapping("/education/page/{pageNo}")
	public String findPaginatedEducation(@PathVariable (value = "pageNo") int pageNo,
											 @RequestParam("sortField") String sortField,
											 @RequestParam("sortDir") String sortDir,
											 Model model) {
		int pageSize = 5;

		Page<Education> page = educationService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Education> listEducation = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEducation", listEducation);
		return "education";
	}

}
