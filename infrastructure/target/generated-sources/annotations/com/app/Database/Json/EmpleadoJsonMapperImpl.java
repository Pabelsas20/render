package com.app.Database.Json;

import com.app.Entities.Empleado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T19:32:23+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class EmpleadoJsonMapperImpl implements EmpleadoJsonMapper {

    @Override
    public Empleado empleadoJsonToEmpleado(EmpleadoJson empleadoJson) {
        if ( empleadoJson == null ) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setId( empleadoJson.getId() );
        empleado.setNombre( empleadoJson.getNombre() );
        empleado.setFecha_nac( empleadoJson.getFecha_nac() );

        return empleado;
    }

    @Override
    public EmpleadoJson empleadoToEmpleadoJson(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoJson empleadoJson = new EmpleadoJson();

        empleadoJson.setId( empleado.getId() );
        empleadoJson.setNombre( empleado.getNombre() );
        empleadoJson.setFecha_nac( empleado.getFecha_nac() );

        return empleadoJson;
    }
}
