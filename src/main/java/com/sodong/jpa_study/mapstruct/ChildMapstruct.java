package com.sodong.jpa_study.mapstruct;

import com.sodong.jpa_study.dto.ChildDto;
import com.sodong.jpa_study.entity.ChildEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = EntityMapstruct.class)
public interface ChildMapstruct extends EntityMapstruct<ChildEntity, ChildDto> {
}

