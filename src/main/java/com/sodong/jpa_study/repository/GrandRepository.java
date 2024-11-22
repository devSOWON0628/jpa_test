package com.sodong.jpa_study.repository;

import com.sodong.jpa_study.entity.GrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandRepository extends JpaRepository<GrandEntity, Integer> {
}
