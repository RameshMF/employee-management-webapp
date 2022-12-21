package net.javaguides.springboot.service;

import net.javaguides.springboot.model.EmploymentContract;
import net.javaguides.springboot.repository.EmploymentContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploymentContractServiceImpl implements EmploymentContractService {
    @Autowired
    private EmploymentContractRepository employmentContractRepository;

    @Override
    public List<EmploymentContract> getAllEmploymentContracts() {
        return employmentContractRepository.findAll();
    }

    @Override
    public void saveEmploymentContract(EmploymentContract employeeContract) {
        this.employmentContractRepository.save(employeeContract);
    }

    @Override
    public EmploymentContract getEmploymentContractById(long id) {
        Optional<EmploymentContract> optional = employmentContractRepository.findById(id);
        EmploymentContract employeeContract = null;
        if (optional.isPresent()) {
            employeeContract = optional.get();
        } else {
            throw new RuntimeException(" EmployeeContract not found for id :: " + id);
        }
        return employeeContract;
    }

    @Override
    public void deleteEmploymentContractById(long id) {
        this.employmentContractRepository.deleteById(id);
    }

    @Override
    public Page<EmploymentContract> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employmentContractRepository.findAll(pageable);
    }
}
