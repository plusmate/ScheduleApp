package com.scheduleGroup.scheduleApp.repository;

import com.scheduleGroup.scheduleApp.lv1.dto.SaveDto;
import com.scheduleGroup.scheduleApp.lv1.repository.ScheduleRepo;
import org.junit.jupiter.api.Test;

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