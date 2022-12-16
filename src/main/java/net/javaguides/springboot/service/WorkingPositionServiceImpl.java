package net.javaguides.springboot.service;

import net.javaguides.springboot.model.WorkingPosition;
import net.javaguides.springboot.repository.WorkingPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingPositionServiceImpl implements WorkingPositionService {
    @Autowired
    private WorkingPositionRepository workingPositionRepository;

    @Override
    public List<WorkingPosition> getAllWorkingPositions() {
        return workingPositionRepository.findAll();
    }

    @Override
    public void saveWorkingPosition(WorkingPosition workingPosition) {
        this.workingPositionRepository.save(workingPosition);
    }

    @Override
    public WorkingPosition getWorkingPositionById(long id) {
        Optional<WorkingPosition> optional = workingPositionRepository.findById(id);
        WorkingPosition workingPosition = null;
        if (optional.isPresent()) {
            workingPosition = optional.get();
        } else {
            throw new RuntimeException(" Working position not found for id :: " + id);
        }
        return workingPosition;
    }

    @Override
    public void deleteWorkingPositionById(long id) {
        this.workingPositionRepository.deleteById(id);
    }

    @Override
    public Page<WorkingPosition> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.workingPositionRepository.findAll(pageable);
    }
}
