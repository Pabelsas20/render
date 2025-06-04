package com.app.Controllers;

import com.app.Entities.EmpleadoHoras;
import com.app.Interactor.IEmpleadoHorasInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/empleados/horas")
public class EmpleadoHorasController {
    private final IEmpleadoHorasInteractor empleadoHorasInteractor;

    @GetMapping()
    List<EmpleadoHoras> getAll(){
        return empleadoHorasInteractor.getAll();
    }
    @GetMapping("/{id}")
    public List<EmpleadoHoras> getByEmpleado(@PathVariable("id") int id_empleado){
        return empleadoHorasInteractor.getByEmpleado(id_empleado, true);
    }
    @GetMapping("/{id}/{registro}")
    public EmpleadoHoras getByEmpleadoRegistro(@PathVariable("id") int id_empleado, @PathVariable("registro") int id_registro){
        return empleadoHorasInteractor.getByEmpleadoRegistro(id_empleado, id_registro);
    }
    @PostMapping()
    public EmpleadoHoras SetUser(@RequestBody EmpleadoHoras u){
        return empleadoHorasInteractor.SetHoras(u);
    }
    @DeleteMapping("/{id}")
    public List<EmpleadoHoras> delEmpleadoById(@PathVariable("id") int id){
        return empleadoHorasInteractor.delByEmpleado(id);
    }
    @DeleteMapping("/{id}/{registro}")
    public EmpleadoHoras delEmpleadoByIdRegistro(@PathVariable("id") int id, @PathVariable("registro") int id_registro){
        EmpleadoHoras e = getByEmpleadoRegistro(id, id_registro);
        return empleadoHorasInteractor.delByEmpleadoRegistro(e);
    }
}
