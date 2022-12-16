package net.javaguides.springboot.service;

import net.javaguides.springboot.model.WorkingPosition;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkingPositionService {
    List<WorkingPosition> getAllWorkingPositions();
    void saveWorkingPosition(WorkingPosition department);
    WorkingPosition getWorkingPositionById(long id);
    void deleteWorkingPositionById(long id);
    Page<WorkingPosition> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
