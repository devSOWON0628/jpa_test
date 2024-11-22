package com.sodong.jpa_study.repository;

import com.sodong.jpa_study.entity.ChildEntity;
import com.sodong.jpa_study.entity.id.ChildEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<ChildEntity, ChildEntityId> {
}
