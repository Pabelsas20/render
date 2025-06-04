package com.app.Database.Mongo;

import com.app.Entities.EmpleadoHoras;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoHorasMapper {
    EmpleadoHoras horasEntityToHoras(EmpleadoHorasEntity empleadoHorasEntity);
    EmpleadoHorasEntity horasToHorasEntity(EmpleadoHoras empleadoHoras);
}
