package com.sodong.jpa_study.service;

import com.sodong.jpa_study.dto.ChildDto;
import com.sodong.jpa_study.dto.GrandResponseDto;
import com.sodong.jpa_study.entity.ChildEntity;
import com.sodong.jpa_study.entity.ParentsEntity;
import com.sodong.jpa_study.mapstruct.ChildMapstruct;
import com.sodong.jpa_study.mapstruct.GrandResponseMapstruct;
import com.sodong.jpa_study.repository.ChildRepository;

import com.sodong.jpa_study.repository.ParentsRepository;

import com.sodong.jpa_study.repository.GrandRepository;
import com.sodong.jpa_study.entity.GrandEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class TestService {
    private final GrandRepository grandRepository;
    private final ParentsRepository parentsRepository;
    private final ChildRepository childRepository;

    private final ChildMapstruct childMapstruct;
    private final GrandResponseMapstruct grandResponseMapstruct;

    public void insertChildTest() {
        GrandEntity grandEntity = GrandEntity.builder().build();
        grandRepository.save(grandEntity);

        ParentsEntity parentsEntity = ParentsEntity.builder().grand(grandEntity).build();
        parentsRepository.save(parentsEntity);


        List<ChildEntity> childEntityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            childEntityList.add(ChildEntity.builder().parents(parentsEntity).build());
        }
        childRepository.saveAll(childEntityList);
    }

    public void bulkInsertGrandEntities() {
        List<GrandEntity> grandEntityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            grandEntityList.add(GrandEntity.builder().build());
        }
        grandRepository.saveAll(grandEntityList);
    }

    public ChildDto findChildDetails(int childId) {
        ChildEntity childEntity = childRepository.findByChildPrimaryKey(childId);
        ChildDto childDto = childMapstruct.toDto(childEntity);
        log.info("childDto: {}", childDto);
        log.info("parentDto: {}", childDto.getParents());
        log.info("grandDto: {}", childDto.getParents().getGrand());
        return childDto;
    }

    public GrandResponseDto findGrandDetails(int grandId) {
        GrandEntity grandEntity = grandRepository.findById(grandId);
        return grandResponseMapstruct.toDto(grandEntity);
    }
}
