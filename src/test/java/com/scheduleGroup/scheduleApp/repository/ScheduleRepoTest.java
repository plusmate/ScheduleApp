package com.scheduleGroup.scheduleApp.repository;

import com.scheduleGroup.scheduleApp.dto.SaveDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleRepoTest {
    private final ScheduleRepo repo;

    public ScheduleRepoTest(ScheduleRepo repo) {
        this.repo = repo;
    }

    @Test
    void scheduleRepoTest() {
        repo.save(new SaveDto("tester1", "pw1", "content1"));
    }
}