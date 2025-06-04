package com.app.Database.Json;


import com.app.Entities.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoJsonMapper {
    Empleado empleadoJsonToEmpleado(EmpleadoJson empleadoJson);
    EmpleadoJson empleadoToEmpleadoJson(Empleado empleado);
}
