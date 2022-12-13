package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}

	@GetMapping("/departments")
	public String departments(Model model) {
//		// create model attribute to bind form data
//		Department departments = new Department();
//		model.addAttribute("departments", departments);
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
		// save employee to database
 		departmentService.saveDepartment(department);
		return "redirect:/departments";
	}

	@GetMapping("/showFormForUpdateDepartment/{id}")
	public String showFormForUpdateDepartment(@PathVariable ( value = "id") long id, Model model) {

		// get employee from the service
		Department department = departmentService.getDepartmentById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("department", department);
		return "update_department";
	}

	@GetMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable (value = "id") long id) {

		// call delete employee method
		this.departmentService.deleteDepartmentById(id);
		return "redirect:/departments";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		List<Department> departments = this.departmentService.getAllDepartments();
		// create model attribute to bind form data
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		model.addAttribute("departments", departments);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.employeeService.deleteEmployeeById(id);
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
}
