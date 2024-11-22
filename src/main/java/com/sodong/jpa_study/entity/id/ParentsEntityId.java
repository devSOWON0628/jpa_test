package com.sodong.jpa_study.entity.id;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ParentsEntityId implements Serializable {
    private Integer grand;               // grand entity 의 pk
    private Integer parentsPrimaryKey; // parents entity의 pk (본인)
}