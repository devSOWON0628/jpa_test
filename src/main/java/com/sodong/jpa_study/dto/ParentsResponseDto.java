package com.sodong.jpa_study.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParentsResponseDto {
    private Integer parentsPrimaryKey;
    private List<ChildResponseDto> children;
}