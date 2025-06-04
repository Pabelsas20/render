package com.app.Database.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoJson {
    private int id;
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nac;
}