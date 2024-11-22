package com.sodong.jpa_study.entity;

import com.sodong.jpa_study.entity.id.ParentsEntityId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "TB_PARENTS")
@TableGenerator(
        name = "parent_generator",
        table = "sequences",
        pkColumnName = "seq",
        allocationSize = 100
)
@IdClass(ParentsEntityId.class) // 복합키
public class ParentsEntity implements Persistable<ParentsEntityId> {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAND_PK", nullable = false)
    private GrandEntity grand;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "parent_generator") // seq 생성
    @Column(name = "PARENTS_PK", nullable = false)
    private Integer parentsPrimaryKey;

    @Override
    public ParentsEntityId getId() {
        return new ParentsEntityId(this.grand.getId(), this.getParentsPrimaryKey());
    }

    @Override
    public boolean isNew() {
        return parentsPrimaryKey == null;
    }
}