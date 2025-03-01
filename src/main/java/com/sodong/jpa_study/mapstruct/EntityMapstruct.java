package com.sodong.jpa_study.mapstruct;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapstruct<Entity, Dto> {
    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    List<Entity> toEntity(List<Dto> dtoList);

    List<Dto> toDto(List<Entity> entityList);
}
