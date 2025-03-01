package com.sodong.jpa_study.mapstruct;

import com.sodong.jpa_study.dto.ParentsDto;
import com.sodong.jpa_study.entity.ParentsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = EntityMapstruct.class)
public interface ParentsMapstruct extends EntityMapstruct<ParentsEntity, ParentsDto> {
}
