package com.sodong.jpa_study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParentsDto {
    private GrandDto grand;
    private Integer parentsPrimaryKey;
}
