package com.sodong.jpa_study.mapstruct;

import com.sodong.jpa_study.dto.GrandResponseDto;
import com.sodong.jpa_study.entity.GrandEntity;
import com.sodong.jpa_study.mapstruct.core.EntityMapstruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = EntityMapstruct.class)
public interface GrandResponseMapstruct extends EntityMapstruct<GrandEntity, GrandResponseDto> {
}