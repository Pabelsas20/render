package com.app.Database.Mongo;

import com.app.Entities.EmpleadoHoras;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T19:32:23+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class EmpleadoHorasMapperImpl implements EmpleadoHorasMapper {

    @Override
    public EmpleadoHoras horasEntityToHoras(EmpleadoHorasEntity empleadoHorasEntity) {
        if ( empleadoHorasEntity == null ) {
            return null;
        }

        EmpleadoHoras empleadoHoras = new EmpleadoHoras();

        empleadoHoras.setId( empleadoHorasEntity.getId() );
        empleadoHoras.setId_empleado( empleadoHorasEntity.getId_empleado() );
        empleadoHoras.setFecha( empleadoHorasEntity.getFecha() );
        empleadoHoras.setHora_inicio( empleadoHorasEntity.getHora_inicio() );
        empleadoHoras.setHora_fin( empleadoHorasEntity.getHora_fin() );

        return empleadoHoras;
    }

    @Override
    public EmpleadoHorasEntity horasToHorasEntity(EmpleadoHoras empleadoHoras) {
        if ( empleadoHoras == null ) {
            return null;
        }

        int id = 0;
        int id_empleado = 0;
        LocalDate fecha = null;
        LocalTime hora_inicio = null;
        LocalTime hora_fin = null;

        id = empleadoHoras.getId();
        id_empleado = empleadoHoras.getId_empleado();
        fecha = empleadoHoras.getFecha();
        hora_inicio = empleadoHoras.getHora_inicio();
        hora_fin = empleadoHoras.getHora_fin();

        EmpleadoHorasEntity empleadoHorasEntity = new EmpleadoHorasEntity( id, id_empleado, fecha, hora_inicio, hora_fin );

        return empleadoHorasEntity;
    }
}
