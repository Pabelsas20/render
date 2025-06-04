/*package com.app.Database.Postgre;


import com.app.Entities.Empleado;
import com.app.Ports.EmpleadoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmpleadoAdapter /*implements EmpleadoPort {
/*    private final EmpleadoJpa empleadoJpa;
    private final EmpleadoMapper empleadoMapper;



    public List<Empleado> getAll() {
        List<Empleado> returnList = new ArrayList<>();
        List<EmpleadoEntity> list = empleadoJpa.findAll();
        for(EmpleadoEntity e: list){
            returnList.add(empleadoMapper.empleadoEntityToEmpleado(e));
        }
        return ordenar(returnList);
    }


    public Empleado GetOne(int id) {
        Optional<EmpleadoEntity> emp = empleadoJpa.findById(id);
        if(emp.isEmpty()){

        }
        EmpleadoEntity empleado = emp.get();
        return empleadoMapper.empleadoEntityToEmpleado(empleado);
    }


    public Empleado SetUser(Empleado u) {
        List<Empleado> users = getAll();
        EmpleadoEntity emp =  empleadoJpa.save(new EmpleadoEntity(primerId(users), u.getNombre(), u.getFecha_nac()));
        return empleadoMapper.empleadoEntityToEmpleado(emp);
    }
    public Empleado SetUserId(Empleado u){
        List<Empleado> users = getAll();
        EmpleadoEntity user =  empleadoJpa.save(new EmpleadoEntity(u.getId(), u.getNombre(), u.getFecha_nac()));
        return empleadoMapper.empleadoEntityToEmpleado(user);
    }


    public Empleado DelUserId(int id) {
        Empleado u = GetOne(id);
        empleadoJpa.deleteById(id);
        return u;
    }


    public List<Empleado> updateUser(Empleado u, int id) {
        Empleado u2 = GetOne(id);
        DelUserId(id);
        SetUserId(new Empleado(id, u.getNombre(), u.getFecha_nac()));
        return (List.of(u2, new Empleado(id, u.getNombre(), u.getFecha_nac())));
    }

    //metodos
    public int primerId(List<Empleado> users){
        boolean seguir = true;
        int i = 1;
        int id = 1;
        while(seguir){
            int iguales = 0;
            for(Empleado user : users){
                if(user.getId() == i){
                    iguales ++;
                }
            }
            if(iguales == 0){
                seguir = false;
                id = i;
            }
            i++;
        }
        return id;
    }

    public List<Empleado> ordenar(List<Empleado> lista){
        lista.sort(Comparator.comparingLong(Empleado::getId));
        return lista;
    }
}*/
