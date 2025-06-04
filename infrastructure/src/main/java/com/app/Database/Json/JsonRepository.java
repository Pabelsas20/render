package com.app.Database.Json;

import com.app.Entities.Empleado;
import com.app.Interactor.EmpleadoHorasInteractor;
import com.app.Ports.EmpleadoPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Component
public class JsonRepository implements EmpleadoPort{
    private final EmpleadoJsonMapper empleadoJsonMapper;
    private final EmpleadoHorasInteractor empleadoHorasInteractor;
    String url = "empleados.json";
    ObjectMapper mapper = new ObjectMapper();
    public JsonRepository(EmpleadoJsonMapper empleadoJsonMapper, EmpleadoHorasInteractor empleadoHorasInteractor) {
        this.empleadoJsonMapper = empleadoJsonMapper;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.empleadoHorasInteractor = empleadoHorasInteractor;
    }


    @Override
    public List<Empleado> getAll(){
        List<EmpleadoJson> empleados = null;
        try {
            File fil = new File(url);
            if (!fil.exists()) {
                System.out.println(fil.getAbsoluteFile());
                throw new RuntimeException("Archivo JSON no encontrado: " + fil.getAbsolutePath());
            }
            empleados = mapper.readValue(
                    new File(url),
                    new TypeReference<List<EmpleadoJson>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Empleado> returnList = new ArrayList<>();
        for(EmpleadoJson e: empleados){
            returnList.add(empleadoJsonMapper.empleadoJsonToEmpleado(e));
        }
        return returnList;
    }

    @Override
    public Empleado GetOne(int id){
        List<Empleado> empleados = getAll();
        for(Empleado e: empleados){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @Override
    public Empleado SetUser(Empleado u){
        List<Empleado> empleados = getAll();
        int id = primerId(empleados);
        Empleado nuevo = new Empleado(id, u.getNombre(), u.getFecha_nac());
        empleados.add(nuevo);
        List<EmpleadoJson> empleadoJsons = new ArrayList<>();
        empleados = ordenar(empleados);
        for(Empleado e: empleados){
            empleadoJsons.add(empleadoJsonMapper.empleadoToEmpleadoJson(e));
        }
        try {
            mapper.writeValue(new File(url), empleadoJsons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nuevo;
    }


    public Empleado SetUserId(Empleado nuevo){
        List<Empleado> empleados = getAll();
        empleados.add(nuevo);
        List<EmpleadoJson> empleadoJsons = new ArrayList<>();
        empleados = ordenar(empleados);
        for(Empleado e: empleados){
            empleadoJsons.add(empleadoJsonMapper.empleadoToEmpleadoJson(e));
        }
        try {
            mapper.writeValue(new File(url), empleadoJsons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nuevo;
    }

    @Override
    public Empleado DelUserId(int id){
        List<Empleado> empleados = getAll();
        int index = -1;
        for(Empleado e: empleados){
            index = empleados.indexOf(e);
        }
        Empleado del = empleados.get(index);
        empleados.remove(del);

        empleados = ordenar(empleados);
        List<EmpleadoJson> empleadoJsons = new ArrayList<>();
        for(Empleado e: empleados){
            empleadoJsons.add(empleadoJsonMapper.empleadoToEmpleadoJson(e));
        }
        try {
            mapper.writeValue(new File(url), empleadoJsons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        empleadoHorasInteractor.delByEmpleado(id);
        return del;
    }

    @Override
    public List<Empleado> updateUser(Empleado u, int id) {
        Empleado nuevo = new Empleado(id, u.getNombre(), u.getFecha_nac());
        return List.of(DelUserId(id), SetUserId(nuevo));
    }

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
}
