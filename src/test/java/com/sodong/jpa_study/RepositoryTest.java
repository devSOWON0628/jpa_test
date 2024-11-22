package com.sodong.jpa_study;

import com.sodong.jpa_study.entity.ChildEntity;
import com.sodong.jpa_study.entity.GrandEntity;
import com.sodong.jpa_study.entity.ParentsEntity;
import com.sodong.jpa_study.repository.ChildRepository;
import com.sodong.jpa_study.repository.GrandRepository;
import com.sodong.jpa_study.repository.ParentsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {
    @Autowired
    private GrandRepository grandRepository;

    @Autowired
    private ParentsRepository parentsRepository;

    @Autowired
    private ChildRepository childRepository;

    @Test
    @DisplayName("grand entity 추가")
    @Transactional
    void addGrandEntity() {
        // given
        GrandEntity grandEntity = GrandEntity.builder().build();
        // when
        grandRepository.save(grandEntity);
        // then
        assertThat(grandEntity.getGrandPrimaryKey()).isNotNull();
    }

    @Test
    @DisplayName("parent entity 추가")
    @Transactional
    void addParentEntity() {
        // given
        GrandEntity grandEntity = GrandEntity.builder().build();
        grandRepository.save(grandEntity);
        ParentsEntity parentsEntity = ParentsEntity.builder().grand(grandEntity).build();
        // when
        parentsRepository.save(parentsEntity);
        // then
        assertThat(grandEntity.getGrandPrimaryKey()).isNotNull();
        assertThat(parentsEntity.getParentsPrimaryKey()).isNotNull();
        assertThat(parentsEntity.getGrand().getGrandPrimaryKey()).isEqualTo(grandEntity.getGrandPrimaryKey());
    }

    @Test
    @DisplayName("child entity 추가")
    @Transactional
    void addChildEntity() {
        // given
        GrandEntity grandEntity = GrandEntity.builder().build();
        ParentsEntity parentsEntity = ParentsEntity.builder().grand(grandEntity).build();
        ChildEntity childEntity = ChildEntity.builder().parents(parentsEntity).build();

        // when
        grandRepository.save(grandEntity);
        parentsRepository.save(parentsEntity);
        childRepository.save(childEntity);

        // then
        assertThat(grandEntity.getGrandPrimaryKey()).isNotNull();

        assertThat(parentsEntity.getParentsPrimaryKey()).isNotNull();
        assertThat(parentsEntity.getGrand().getGrandPrimaryKey()).isEqualTo(grandEntity.getGrandPrimaryKey());

        assertThat(childEntity.getChildPrimaryKey()).isNotNull();
        assertThat(childEntity.getParents().getParentsPrimaryKey()).isEqualTo(parentsEntity.getParentsPrimaryKey());
        assertThat(childEntity.getParents().getGrand().getGrandPrimaryKey()).isEqualTo(grandEntity.getGrandPrimaryKey());
    }
}
