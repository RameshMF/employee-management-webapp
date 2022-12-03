package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(long id);
    void deleteDepartmentById(long id);
    Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
