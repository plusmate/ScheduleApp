package com.scheduleGroup.scheduleApp.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleEntity {
    private static Long idCounter = 0L;
    private Long id;
    private String name;
    private String password;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public ScheduleEntity(String name, String password, String content) {
        this.id = ++idCounter;
        this.name = name;
        this.password = password;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
        return updatedDate;
    }
}
