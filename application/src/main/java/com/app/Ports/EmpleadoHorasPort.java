package com.app.Ports;

import com.app.Entities.EmpleadoHoras;

import java.util.List;

public interface EmpleadoHorasPort {
    public List<EmpleadoHoras> getAll();
    public List<EmpleadoHoras> getByEmpleado(int id, boolean exc);
    public EmpleadoHoras getByEmpleadoRegistro(int id, int registro);
    public EmpleadoHoras SetHoras(EmpleadoHoras u);
    public List<EmpleadoHoras> delByEmpleado(int id);
    public EmpleadoHoras delByEmpleadoRegistro(EmpleadoHoras e);
}
