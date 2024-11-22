package com.sodong.jpa_study.repository;

import com.sodong.jpa_study.entity.ParentsEntity;
import com.sodong.jpa_study.entity.id.ParentsEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentsRepository extends JpaRepository<ParentsEntity, ParentsEntityId> {
}
