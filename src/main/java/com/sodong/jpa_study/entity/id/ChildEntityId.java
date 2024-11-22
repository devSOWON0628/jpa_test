package com.sodong.jpa_study.entity.id;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChildEntityId implements Serializable {
    private ParentsEntityId parents; // parents의 pk
    private Integer childPrimaryKey; // child entity의 pk (본인)
}