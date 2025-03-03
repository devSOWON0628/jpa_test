package com.sodong.jpa_study.entity.id;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ParentsEntityId implements Serializable {

    private static final long serialVersionUID = -10000000001L;

    private Integer grand;              // grand entity 의 pk
    private Integer parentsPrimaryKey;  // parents entity의 pk (본인)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentsEntityId that)) return false;
        return grand.equals(that.grand) && parentsPrimaryKey.equals(that.parentsPrimaryKey);
    }

    @Override
    public int hashCode() {
        return grand.hashCode() + parentsPrimaryKey.hashCode();
    }
}