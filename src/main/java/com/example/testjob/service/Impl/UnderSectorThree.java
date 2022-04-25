package com.example.testjob.service.Impl;

import com.example.testjob.model.entity.UnderSectorThreeEntity;
import com.example.testjob.repository.UnderSectorThreeRepository;
import com.example.testjob.service.UnderSectorThreeService;
import org.springframework.stereotype.Service;

@Service
public class UnderSectorThree implements UnderSectorThreeService {

    private final UnderSectorThreeRepository underSectorThreeRepository;

    public UnderSectorThree(UnderSectorThreeRepository underSectorThreeRepository) {
        this.underSectorThreeRepository = underSectorThreeRepository;
    }

    @Override
    public boolean checkUnderSectorThreeExistsById(Long id) {

        UnderSectorThreeEntity referenceById = this.underSectorThreeRepository
                .getById(id);

        return referenceById.getName() != null;
    }
}
