package com.sodong.jpa_study.api;

import com.sodong.jpa_study.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    @GetMapping("/child")
    public void test(){
        testService.childInsertTest();
    }

    @GetMapping("/grand/bulk")
    public void bulk(){
        testService.bulkInsertTest();
    }
}
