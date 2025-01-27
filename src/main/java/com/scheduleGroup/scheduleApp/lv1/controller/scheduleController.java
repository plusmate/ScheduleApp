package com.scheduleGroup.scheduleApp.lv1.controller;

import com.scheduleGroup.scheduleApp.lv1.dto.SaveDto;
import com.scheduleGroup.scheduleApp.lv1.repository.ScheduleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleRepo scheduleRepo;

    /**
     * 일정 생성
     *
     * @param name
     * @param password
     * @param content
     * @Return http 상태코드
     */
    @PostMapping("/lv1/newSchedule")
    public ResponseEntity<String> newSchedule(@RequestParam("name") String name,
                                              @RequestParam("password") String password,
                                              @RequestParam("content") String content) {
        SaveDto saveDto = new SaveDto(name, password, content);
        scheduleRepo.save(saveDto);

        return ResponseEntity.ok("레코드 생성 완료");
    }

    @GetMapping("/lv1/search/{name}/{startDate}/{endDate}")
    public List<Map<String, Object>> findByDate(@PathVariable("startDate") String startDate,
                                                    @PathVariable("endDate") String endDate,
                                                    @PathVariable("name") String name) {
        List<Map<String, Object>> searchedSchedule = scheduleRepo.findByDate(startDate, endDate, name);

        return ResponseEntity.ok(searchedSchedule).getBody();
    }

    @GetMapping("/lv1/search/{id}")
    public Map<String, Object> findById(@PathVariable("id") Long id) {
        Map<String, Object> searchedSchedule = scheduleRepo.findById(id);

        return ResponseEntity.ok(searchedSchedule).getBody();
    }
}
