package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.WorkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingPositionRepository extends JpaRepository<WorkingPosition, Long> {
}
