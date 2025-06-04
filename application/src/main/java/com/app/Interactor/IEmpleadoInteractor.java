package com.app.Interactor;

import com.app.Entities.Empleado;
import com.app.Ports.EmpleadoPort;

import java.util.List;
import java.util.Optional;


public interface IEmpleadoInteractor extends EmpleadoPort {
    List<Empleado> getAll();
    public Empleado GetOne(int id);
    Empleado SetUser(Empleado u);
    Empleado DelUserId(int id);
    List<Empleado> updateUser(Empleado u, int id);
}
