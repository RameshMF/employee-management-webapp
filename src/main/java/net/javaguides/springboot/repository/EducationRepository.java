package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
