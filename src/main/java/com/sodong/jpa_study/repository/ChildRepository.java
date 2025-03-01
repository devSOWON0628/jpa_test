package com.sodong.jpa_study.repository;

import com.sodong.jpa_study.entity.ChildEntity;
import com.sodong.jpa_study.entity.id.ChildEntityId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<ChildEntity, ChildEntityId> {
    @EntityGraph(attributePaths = {"parents", "parents.grand"})
    ChildEntity findByChildPrimaryKey(int childId);
}
