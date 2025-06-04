package com.app.Database.Mongo;

import com.app.Entities.EmpleadoHoras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoHorasMongo extends MongoRepository<EmpleadoHorasEntity, Integer> {
    @Query("{ 'id_empleado' : ?0 }")
    List<EmpleadoHorasEntity> findByIdEmpleado(int id_empleado);
}
