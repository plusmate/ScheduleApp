package com.scheduleGroup.scheduleApp.lv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Getter
public class EditDto {
    private final Long id;
    private final String pw;
    private final String name;
    private final String content;
}
