package com.sodong.jpa_study.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "TB_GRAND")
@TableGenerator(
        name = "grand_generator", // id 생성기 이름
        table = "sequences",// 테이블 명
        pkColumnName = "seq",// 시퀀스 컬럼명
        allocationSize = 100 // 시퀀스 한 번 호출할때마다 증가
)
public class GrandEntity implements Persistable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "grand_generator") // seq 생성
    @Column(name = "GRAND_PK", nullable = false)
    private Integer grandPrimaryKey;

    @Override
    public Integer getId() {
        return this.grandPrimaryKey;
    }

    @Override
    public boolean isNew() {
        return grandPrimaryKey == null;
    }
}