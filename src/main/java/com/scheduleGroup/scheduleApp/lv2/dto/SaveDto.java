package com.scheduleGroup.scheduleApp.lv2.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class SaveDto {
    private String name;
    private String password;
    private String content;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public SaveDto(String name, String password, String content) {
        this.content = content;
        this.name = name;
        this.password = password;
        this.createdDate = LocalDateTime.now().toLocalDate();
        this.updatedDate = LocalDateTime.now().toLocalDate();
    }
}
