package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.EmployeeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypesRepository extends JpaRepository<EmployeeTypes, Long> {
}
