package com.sodong.jpa_study.entity.id;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChildEntityId implements Serializable {

    private static final long serialVersionUID = -10000000002L;

    private ParentsEntityId parents; // parents의 pk
    private Integer childPrimaryKey; // child entity의 pk (본인)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChildEntityId that)) return false;
        return parents.equals(that.parents) && childPrimaryKey.equals(that.childPrimaryKey);
    }

    @Override
    public int hashCode() {
        return parents.hashCode() + childPrimaryKey.hashCode();
    }
}