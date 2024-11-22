package com.sodong.jpa_study;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JpaStudyApplicationTest {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("성공 TEST")
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }
}
