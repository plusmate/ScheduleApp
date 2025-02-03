package com.scheduleGroup.scheduleApp.lv2.controller;

import com.scheduleGroup.scheduleApp.lv2.dto.SaveDto;
import com.scheduleGroup.scheduleApp.lv2.repository.ScheduleRepo;
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
     * 일정 생성 컨트롤러
     *
     * @param name
     * @param password
     * @param content
     * @Return http 상태코드
     */
    @PostMapping("/newSchedule")
    public ResponseEntity<String> newSchedule(@RequestParam("name") String name,
                                              @RequestParam("password") String password,
                                              @RequestParam("content") String content) {
        SaveDto saveDto = new SaveDto(name, password, content);
        scheduleRepo.save(saveDto);

        return ResponseEntity.ok("레코드 생성 완료");
    }

    /**
     * 날짜 범위를 이용한 일정 검색 컨트롤러
     *
     * @param startDate
     * @param endDate
     * @param name
     * @return
     */
    @GetMapping("/search/{name}/{startDate}/{endDate}")
    public List<Map<String, Object>> findByDate(@PathVariable("startDate") String startDate,
                                                @PathVariable("endDate") String endDate,
                                                @PathVariable("name") String name) {
        List<Map<String, Object>> searchedSchedule = scheduleRepo.findByDate(startDate, endDate, name);

        return ResponseEntity.ok(searchedSchedule).getBody();
    }

    /**
     * id를 이용한 단일 일정 검색 컨트롤러
     *
     * @param id
     * @return
     */
    @GetMapping("/search/{id}")
    public Map<String, Object> findById(@PathVariable("id") Long id) {
        Map<String, Object> searchedSchedule = scheduleRepo.findById(id);

        return ResponseEntity.ok(searchedSchedule).getBody();
    }


    /**
     * 일정 수정 컨트롤러
     * > name과 content는 null 가능
     * @param id
     * @param pw
     * @param name
     * @param content
     */
    @PostMapping("/edit")
    public Map<String, Object> editSchedule(@RequestParam("id") Long id,
                                            @RequestParam("pw") String pw,
                                            @RequestParam(required = false, name = "name") String name,
                                            @RequestParam(required = false, name = "content") String content) {
        Map<String, Object> editResult = scheduleRepo.edit(id, pw, name, content);

        return ResponseEntity.ok(editResult).getBody();
    }

    /**
     * 단일 일정 삭제 컨트롤러
     * @param id
     * @param pw
     */
    @DeleteMapping("/delete")
    public void deleteSchedule(@RequestParam("id") Long id,
                               @RequestParam("pw") String pw) {
        scheduleRepo.deleteSchedule(id, pw);
    }
}
