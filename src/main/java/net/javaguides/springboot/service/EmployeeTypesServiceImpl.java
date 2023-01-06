package net.javaguides.springboot.service;

import net.javaguides.springboot.model.EmployeeTypes;
import net.javaguides.springboot.repository.EmployeeTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypesServiceImpl implements EmployeeTypesService {
    @Autowired
    private EmployeeTypesRepository employeeTypesRepository;
    @Override
    public List<EmployeeTypes> getAllEmployeeTypes() {
        return employeeTypesRepository.findAll();
    }
}
