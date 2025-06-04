package com.app.Interactor;

import com.app.Entities.EmpleadoHoras;
import com.app.Ports.EmpleadoHorasPort;
import com.app.Validation.HorasValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoHorasInteractor implements IEmpleadoHorasInteractor{
    private final EmpleadoHorasPort empleadoHorasPort;
    private final HorasValidation horasValidation;

    public List<EmpleadoHoras> getAll() {
        return empleadoHorasPort.getAll();
    }

    public List<EmpleadoHoras> getByEmpleado(int id, boolean exc) {
        List<EmpleadoHoras> list = empleadoHorasPort.getByEmpleado(id, exc);
        if(list.isEmpty() && exc){
            throw new ResourceNotFoundException();
        }
        return list;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }

    public EmpleadoHoras getByEmpleadoRegistro(int id, int registro) {
        List<EmpleadoHoras> list = empleadoHorasPort.getByEmpleado(id, true);
        EmpleadoHoras returnEmp = new EmpleadoHoras();
        boolean exist = false;
        for(EmpleadoHoras e: list){
            if(e.getId() == registro){
                returnEmp = e;
                exist = true;
            }
        }
        if (exist == false) {
            throw new ResourceNotFoundException();
        }
        return returnEmp;
    }
    public EmpleadoHoras SetHoras(EmpleadoHoras u) {
        if(horasValidation.ValidarHoras(u)){
            return empleadoHorasPort.SetHoras(u);
        }
        return null;
    }

    public List<EmpleadoHoras> delByEmpleado(int id) {
        return empleadoHorasPort.delByEmpleado(id);
    }
    public EmpleadoHoras delByEmpleadoRegistro(EmpleadoHoras e){
        return empleadoHorasPort.delByEmpleadoRegistro(e);
    }

    //motodos no API

    public Duration horasTotales(int empleado){
        Duration total = Duration.ZERO;
        List<EmpleadoHoras> list = getByEmpleado(empleado, false);
        for(EmpleadoHoras e: list){
            Duration dif = Duration.between(e.getHora_fin(), e.getHora_inicio());
            total = total.plus(dif);
        }
        return total;
    }
}
