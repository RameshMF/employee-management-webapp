package net.javaguides.springboot.service;

import net.javaguides.springboot.model.FamilyMember;
import net.javaguides.springboot.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberServiceImpl implements ItemStorageService<FamilyMember> {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Override
    public List<FamilyMember> getAllItems() {
        return familyMemberRepository.findAll();
    }

    @Override
    public void saveItem(FamilyMember item)
    {
        this.familyMemberRepository.save(item);
    }

    @Override
    public FamilyMember getItemById(long id) {
        Optional<FamilyMember> optional = familyMemberRepository.findById(id);
        FamilyMember familyMember = null;
        if (optional.isPresent()) {
            familyMember = optional.get();
        } else {
            throw new RuntimeException(" FamilyMember not found for id :: " + id);
        }

        return familyMember;
    }

    @Override
    public void deleteItemById(long id) {
        this.familyMemberRepository.deleteById(id);
    }

    @Override
    public Page<FamilyMember> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return this.familyMemberRepository.findAll(pageable);
    }
}
