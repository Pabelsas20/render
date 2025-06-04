package com.app.Validation;

import com.app.Entities.EmpleadoHoras;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HorasValidation {
    public boolean ValidarHoras(EmpleadoHoras horas){
        if(horas.getHora_inicio().isAfter(horas.getHora_fin())){
            return false;
        }
        return true;
    }
}
