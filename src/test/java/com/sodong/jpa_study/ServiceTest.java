package com.sodong.jpa_study;

import com.sodong.jpa_study.repository.ChildRepository;
import com.sodong.jpa_study.repository.GrandRepository;
import com.sodong.jpa_study.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ServiceTest {
    @Autowired
    TestService testService;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    GrandRepository grandRepository;

    @Test
    @DisplayName("child Insert Test")
    @Transactional
    void addChild10InsertTest() {
        // given
        testService.childInsertTest();
        // when
        long childCount = childRepository.count();
        // then
        assertThat(childCount).isEqualTo(10);
    }

    @Test
    @DisplayName("grand bulk insert test")
    @Transactional
    void addGrandInsertTest() {
        // given
        testService.bulkInsertTest();
        // when
        long grandCount = grandRepository.count();
        // then
        assertThat(grandCount).isEqualTo(10);
    }
}
