package com.sodong.jpa_study.entity;

import com.sodong.jpa_study.entity.id.ChildEntityId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;


import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_CHILD")
@TableGenerator(
        name = "child_generator",
        table = "sequences",
        pkColumnName = "seq",
        allocationSize = 100
)
@IdClass(ChildEntityId.class) // 복합키
public class ChildEntity implements Persistable<ChildEntityId>, Serializable {

    private static final long serialVersionUID = -10000000001L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "GRAND_PK", referencedColumnName = "GRAND_PK"),
            @JoinColumn(name = "PARENTS_PK", referencedColumnName = "PARENTS_PK")
    })
    private ParentsEntity parents;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "child_generator") // seq 생성
    @Column(name = "CHILD_PK", nullable = false)
    private Integer childPrimaryKey;

    @Override
    public ChildEntityId getId() {
        return new ChildEntityId(parents.getId(), childPrimaryKey);
    }

    @Override
    public boolean isNew() {
        return childPrimaryKey == null ||
                (getParents() == null || getParents().getParentsPrimaryKey() == null) ||
                (getParents() != null && getParents().getGrand() != null && getParents().getGrand().getGrandPrimaryKey() == null);
    }

}

