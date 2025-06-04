package com.app.Database.Mongo;



import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Document(collection = "EmpleadoHoras")
public class EmpleadoHorasEntity {
    @Id
    private int id;
    private int id_empleado;
    private LocalDate fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;

}
