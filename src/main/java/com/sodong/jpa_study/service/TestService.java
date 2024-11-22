package com.sodong.jpa_study.service;

import com.sodong.jpa_study.entity.ChildEntity;
import com.sodong.jpa_study.entity.ParentsEntity;
import com.sodong.jpa_study.repository.ChildRepository;

import com.sodong.jpa_study.repository.ParentsRepository;

import com.sodong.jpa_study.repository.GrandRepository;
import com.sodong.jpa_study.entity.GrandEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TestService {
    private final GrandRepository grandRepository;
    private final ParentsRepository parentsRepository;
    private final ChildRepository childRepository;

    public void childInsertTest() {
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

    public void bulkInsertTest() {
        List<GrandEntity> grandEntityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            grandEntityList.add(GrandEntity.builder().build());
        }
        grandRepository.saveAll(grandEntityList);
    }
}
