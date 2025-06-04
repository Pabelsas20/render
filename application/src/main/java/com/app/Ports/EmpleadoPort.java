package com.app.Ports;

import com.app.Entities.Empleado;

import java.util.List;
import java.util.Optional;


public interface EmpleadoPort {
    List<Empleado> getAll();
    Empleado GetOne(int id);
    Empleado SetUser(Empleado u);
    Empleado DelUserId(int id);
    List<Empleado> updateUser(Empleado u, int id);
}
