package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.KinshipDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KinshipDegreeRepository extends JpaRepository<KinshipDegree, Long> {
}
