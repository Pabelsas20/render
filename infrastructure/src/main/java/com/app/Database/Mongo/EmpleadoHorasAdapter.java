package com.app.Database.Mongo;

import com.app.Entities.EmpleadoHoras;
import com.app.Ports.EmpleadoHorasPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@EnableMongoRepositories
public class EmpleadoHorasAdapter implements EmpleadoHorasPort {
    private final EmpleadoHorasMongo empleadoHorasMongo;
    private final EmpleadoHorasMapper empleadoHorasMapper;

    public List<EmpleadoHoras> getAll(){
        List<EmpleadoHoras> returnList = new ArrayList<>();
        List<EmpleadoHorasEntity> list = empleadoHorasMongo.findAll();
        for(EmpleadoHorasEntity e: list){
            returnList.add(empleadoHorasMapper.horasEntityToHoras(e));
        }
        return returnList;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
    }

    public List<EmpleadoHoras> getByEmpleado(int id, boolean esc) {
        List<EmpleadoHoras> returnList = new ArrayList<>();
        List<EmpleadoHorasEntity> list = empleadoHorasMongo.findByIdEmpleado(id);

        for(EmpleadoHorasEntity e: list){
            returnList.add(empleadoHorasMapper.horasEntityToHoras(e));
        }
        return returnList;
    }

    public EmpleadoHoras getByEmpleadoRegistro(int id, int registro) {
        return null;
    }

    public EmpleadoHoras SetHoras(EmpleadoHoras u) {
        List<EmpleadoHoras> horas = getAll();
        EmpleadoHorasEntity emp =  empleadoHorasMongo.save(new EmpleadoHorasEntity(primerId(horas), u.getId_empleado(),u.getFecha(), u.getHora_inicio(), u.getHora_fin()));
        return empleadoHorasMapper.horasEntityToHoras(emp);
    }


    public List<EmpleadoHoras> delByEmpleado(int id) {
        List<EmpleadoHoras> list = getByEmpleado(id, true);
        for(EmpleadoHoras e: list){
            empleadoHorasMongo.delete(empleadoHorasMapper.horasToHorasEntity(e));
        }
        return list;
    }
    public EmpleadoHoras delByEmpleadoRegistro(EmpleadoHoras e) {
        empleadoHorasMongo.delete(empleadoHorasMapper.horasToHorasEntity(e));
        return e;
    }


    public int primerId(List<EmpleadoHoras> users){
        boolean seguir = true;
        int i = 1;
        int id = 1;
        while(seguir){
            int iguales = 0;
            for(EmpleadoHoras user : users){
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
}
