package com.app.Interactor;

import com.app.Entities.EmpleadoHoras;
import com.app.Ports.EmpleadoHorasPort;

import java.util.List;

public interface IEmpleadoHorasInteractor extends EmpleadoHorasPort {
    public List<EmpleadoHoras> getAll();
    public List<EmpleadoHoras> getByEmpleado(int id, boolean exc);
    public EmpleadoHoras getByEmpleadoRegistro(int id, int registro);
    public EmpleadoHoras SetHoras(EmpleadoHoras u);

    List<EmpleadoHoras> delByEmpleado(int id);
    EmpleadoHoras delByEmpleadoRegistro(EmpleadoHoras e);
}
