package com.app.Entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
public class EmpleadoHoras {
    private int id;
    private int id_empleado;
    private LocalDate fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
}
