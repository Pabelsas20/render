package com.app.Interactor;

import com.app.Entities.Empleado;
import com.app.Ports.EmpleadoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoInteractor implements IEmpleadoInteractor{
    private final EmpleadoPort empleadoPort;

    public List<Empleado> getAll() {
        return empleadoPort.getAll();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }
    public Empleado GetOne(int id) {
       return empleadoPort.GetOne(id);
    }

    public Empleado SetUser(Empleado u) {
        return empleadoPort.SetUser(u);
    }

    public Empleado DelUserId(int id) {
        return empleadoPort.DelUserId(id);
    }

    public List<Empleado> updateUser(Empleado u, int id) {
        return empleadoPort.updateUser(u, id);
    }
}
