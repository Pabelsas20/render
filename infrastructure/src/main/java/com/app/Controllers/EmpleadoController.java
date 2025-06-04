package com.app.Controllers;

import com.app.Entities.Empleado;
import com.app.Interactor.IEmpleadoInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final IEmpleadoInteractor empleadoInteractor;

    @GetMapping()
    List<Empleado> getAll(){
        return empleadoInteractor.getAll();
    }
    @GetMapping("/{id}")
    public Empleado GetOne(@PathVariable("id") int id){
        return empleadoInteractor.GetOne(id);
    }
    @PostMapping()
    public Empleado SetUser(@RequestBody Empleado u){
        return empleadoInteractor.SetUser(u);
    }
    @DeleteMapping("/{id}")
    public Empleado DelUserId(@PathVariable("id") int id){
        return empleadoInteractor.DelUserId(id);
    }
    @PutMapping("/{id}")
    public List<Empleado> updateUser(@RequestBody Empleado u, @PathVariable("id") int id){
        return empleadoInteractor.updateUser(u, id);
    }
}
