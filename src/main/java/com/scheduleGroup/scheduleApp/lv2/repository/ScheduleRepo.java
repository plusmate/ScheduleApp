package com.scheduleGroup.scheduleApp.lv2.repository;

import com.scheduleGroup.scheduleApp.lv2.dto.SaveDto;
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

    public Map<String, Object> findByPw(Long id, String pw) {
        String findByPwSQL = "SELECT * FROM schedule WHERE id = ? AND password = ?";

        Map<String, Object> searchObj = jdbcTemplate.queryForMap(findByPwSQL, id, pw);

        return searchObj;
    }

    public Map<String, Object> edit(Long id, String pw, String name, String content) {
        if (checkPw(id, pw)) {
            String editSQL;
            if (name != null && content == null) {
                editSQL = "UPDATE schedule SET name = ?, updated_date = CURDATE() WHERE id = ?";
                jdbcTemplate.update(editSQL, name, id);
            } else if (name == null && content != null) {
                editSQL = "UPDATE schedule SET content = ?, updated_date = CURDATE() WHERE id = ?";
                jdbcTemplate.update(editSQL, content, id);
            } else if (name != null && content != null) {
                editSQL = "UPDATE schedule SET name = ?,  content = ?, updated_date = CURDATE() WHERE id = ?";
                jdbcTemplate.update(editSQL, name, content, id);
            }

            return findById(id);
        } else {
            return null;
        }
    }

    private boolean checkPw(Long id, String pw) {
        return !findByPw(id, pw).isEmpty();
    }
}
