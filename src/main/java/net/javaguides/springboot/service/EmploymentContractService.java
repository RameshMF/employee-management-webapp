package net.javaguides.springboot.service;

import net.javaguides.springboot.model.EmploymentContract;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmploymentContractService {
    List<EmploymentContract> getAllEmploymentContracts();
    void saveEmploymentContract(EmploymentContract employeeContract);
    EmploymentContract getEmploymentContractById(long id);
    void deleteEmploymentContractById(long id);
    Page<EmploymentContract> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
