package com.scheduleGroup.scheduleApp.repository;

import com.scheduleGroup.scheduleApp.dto.SaveDto;
import com.scheduleGroup.scheduleApp.entity.ScheduleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScheduleRepo {

    private final JdbcTemplate jdbcTemplate;

    public void save(SaveDto saveDto) {
        String saveSQL = "INSERT INTO schedule (name, password, content) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                saveSQL,
                saveDto.getName(),
                saveDto.getPassword(),
                saveDto.getContent()
        );
    }
}
