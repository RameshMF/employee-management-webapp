package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements ItemStorageService<Department> {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllItems() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveItem(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public Department getItemById(long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = null;
        if (optional.isPresent()) {
            department = optional.get();
        } else {
            throw new RuntimeException(" Department not found for id :: " + id);
        }
        return department;
    }

    @Override
    public void deleteItemById(long id) {
        this.departmentRepository.deleteById(id);
    }

    @Override
    public Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.departmentRepository.findAll(pageable);
    }
}
