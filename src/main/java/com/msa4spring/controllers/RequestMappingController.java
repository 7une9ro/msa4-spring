package com.msa4spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// [NOTE]: REST API 컨트롤러라는 걸 Spring Controller가 인식하게 함 (2026-05-13, JunHyeon)
// [NOTE]: @RestController는 기본적으로 @Component 어노테이션을 포함하고 있음 (2026-05-13, JunHyeon)
@RestController
// [NOTE]: 클래스 레벨의 URL Mapping, 그룹핑할 수도 있음 (2026-05-13, JunHyeon)
@RequestMapping("/api")
public class RequestMappingController {

    // [NOTE]: 메서드 레벨의 URL Mapping (2026-05-13, JunHyeon)
    @GetMapping("/test")
    public String getTest() {
        return "GET 테스트";
    }

    @PostMapping("/test")
    public String postTest() {
        return "POST 테스트";
    }
}
