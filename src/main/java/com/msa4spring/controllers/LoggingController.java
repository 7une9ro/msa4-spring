package com.msa4spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // [NOTE]: logging을 위한 어노테이션을 클래스 레벨에 추가 (2026-05-14, JunHyeon)
@RestController
@RequestMapping("/api")
public class LoggingController {

    @GetMapping("/log")
    public String logging() {
        log.trace("trace level");
        log.debug("debug level");
        log.info("info level");
        log.warn("warning level");
        log.error("error level");

        return "GET: log";
    }
}
