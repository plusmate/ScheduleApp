package com.scheduleGroup.scheduleApp.lv1.repository;

import com.scheduleGroup.scheduleApp.lv1.dto.SaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ScheduleRepo {

    private final JdbcTemplate jdbcTemplate;

    public void save(SaveDto saveDto) {
        String saveSQL = "INSERT INTO schedule (name, password, content, created_date, updated_date) VALUES (?, ?, ?, ?, ?)";

        int update = jdbcTemplate.update(
                saveSQL,
                saveDto.getName(),
                saveDto.getPassword(),
                saveDto.getContent(),
                saveDto.getCreatedDate(),
                saveDto.getUpdatedDate()
        );
    }

    public List<Map<String, Object>> findByDate(String startDate, String endDate, String name) {
        String findByDateSQL = "SELECT * FROM schedule WHERE (updated_date BETWEEN ? AND ?) OR name = ?";


        List<Map<String, Object>> searchList = jdbcTemplate.queryForList(findByDateSQL, startDate, endDate, name);

        return searchList;
    }

    public Map<String, Object> findById(Long id) {
        String findByIdSQL = "SELECT * FROM schedule WHERE id = ?";

        Map<String, Object> searchList = jdbcTemplate.queryForMap(findByIdSQL, id);

        return searchList;
    }

}
