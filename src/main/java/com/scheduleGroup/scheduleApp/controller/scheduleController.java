package com.scheduleGroup.scheduleApp.controller;

import com.scheduleGroup.scheduleApp.dto.SaveDto;
import com.scheduleGroup.scheduleApp.repository.ScheduleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleRepo scheduleRepo;

    @GetMapping("/main")
    public String mainPage() {
        return "mainPage";
    }

    /**
     * 테이블에 데이터 저장
     * @Return http 상태코드
     * @param name
     * @param password
     * @param content
     */
    @PostMapping("/newSchedule")
    public ResponseEntity<Void> newSchedule(@RequestParam("name") String name,
                            @RequestParam("password") String password,
                            @RequestParam("content") String content) {
        SaveDto saveDto = new SaveDto(name, password, content);
        scheduleRepo.save(saveDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
