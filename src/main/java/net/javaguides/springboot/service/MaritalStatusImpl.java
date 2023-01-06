package net.javaguides.springboot.service;

import net.javaguides.springboot.model.MaritalStatus;
import net.javaguides.springboot.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritalStatusImpl implements MaritalStatusService {
    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @Override
   public List<MaritalStatus> getAllMaritalStatus() {
        return maritalStatusRepository.findAll();
    }
}
