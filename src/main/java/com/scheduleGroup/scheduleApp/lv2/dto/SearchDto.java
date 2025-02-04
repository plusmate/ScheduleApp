package com.scheduleGroup.scheduleApp.lv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class SearchDto {
    private final String name;
    private final String  startDate;
    private final String  endDate;
}
