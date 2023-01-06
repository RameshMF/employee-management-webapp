package net.javaguides.springboot.service;

import net.javaguides.springboot.model.FormOfStudy;
import net.javaguides.springboot.model.KinshipDegree;
import net.javaguides.springboot.repository.FormOfStudyRepository;
import net.javaguides.springboot.repository.KinshipDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormOfStudyImpl implements FormOfStudyService {
    @Autowired
    private FormOfStudyRepository formOfStudyRepository;

    @Override
    public List<FormOfStudy> getAllFormsOfStudy() {
        return this.formOfStudyRepository.findAll();
    }

}
