package com.sodong.jpa_study.api;

import com.sodong.jpa_study.dto.ChildDto;
import com.sodong.jpa_study.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class TestController {
    private final TestService testService;

    // Child 엔티티 삽입 테스트
    @GetMapping("/child/test-insert")
    public void insertChildTest() {
        testService.insertChildTest();
    }

    // Grand 엔티티 일괄 삽입 테스트
    @GetMapping("/grand/test-bulk-insert")
    public void bulkInsertGrandEntities() {
        testService.bulkInsertGrandEntities();
    }

    // 특정 Child 엔티티 조회 및 그와 관련된 부모, 할머니 정보 반환 n+1
    @GetMapping("/child/{childId}")
    public ChildDto getChildDetails(@PathVariable int childId) {
        return testService.findChildDetails(childId);
    }
}
