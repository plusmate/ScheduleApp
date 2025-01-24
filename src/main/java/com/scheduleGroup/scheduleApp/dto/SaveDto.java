package com.scheduleGroup.scheduleApp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SaveDto {
    private String name;
    private String password;
    private String content;

    public SaveDto(String name, String password, String content) {
        this.content = content;
        this.name = name;
        this.password = password;
    }

}
