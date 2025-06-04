package com.app.Controllers;

import com.app.Entities.Empleado;
import com.app.Entities.EmpleadoHoras;
import com.app.Interactor.EmpleadoHorasInteractor;
import com.app.Interactor.EmpleadoInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final EmpleadoInteractor empleadoInteractor;
    private final EmpleadoHorasInteractor empleadoHorasInteractor;


    @GetMapping()
    public String showView() throws FileNotFoundException {
        return "index";
    }
    @GetMapping("/lista")
    public String showView2(Model model){
        Map<Integer, String> horas = new HashMap<>(Map.of());
        List<Empleado> users = empleadoInteractor.getAll();
        for(Empleado e: users){
            Duration hora = empleadoHorasInteractor.horasTotales(e.getId());
            int h = Math.abs((int)hora.toHours());
            int m = Math.abs((int)hora.toMinutes()%60);
            String hora_f;
            if(h == 0 && m == 0){
                hora_f = String.format("%dh", h);
            }else if(h == 0){
                hora_f = String.format("%dm", m);
            }else if (m == 0) {
                hora_f = String.format("%dh", h);
            }else{
                hora_f = String.format("%dh y %dm", h, m);
            }
            horas.put(e.getId(), hora_f);
        }
        model.addAttribute("users", users);
        model.addAttribute("u", new Empleado());
        model.addAttribute("horas", horas);

        return "lista";
    }

    @PostMapping("/api/empleados/eliminar/{id}")
    public String DelUserId2(@PathVariable("id") int id){
        empleadoInteractor.DelUserId(id);
        empleadoHorasInteractor.delByEmpleado(id);
        return "redirect:/lista";
    }

    @PostMapping("api/empleados/crear")
    public String crearEmpleado(@ModelAttribute Empleado user) {
        empleadoInteractor.SetUser(user);
        return "redirect:/lista";  // Redirige después de crear
    }

    @PostMapping("api/empleados/actualizar")
    public String actualizarEmpleado(@ModelAttribute Empleado user,  @RequestParam Integer id) {
        System.out.println(id);
        empleadoInteractor.updateUser(user, id);
        return "redirect:/lista";  // Redirige después de crear
    }

    @GetMapping("/horas/{id}")
    public String showHorasView(@PathVariable("id") int id, Model model){
        List<EmpleadoHoras> horas = empleadoHorasInteractor.getByEmpleado(id, false);
        if(horas == null){
            horas = List.of();
        }
        model.addAttribute("user", empleadoInteractor.GetOne(id));
        model.addAttribute("horas", horas);
        model.addAttribute("h", new EmpleadoHoras());
        return "horas";
    }

    @PostMapping("/api/empleados/horas/eliminar/{id}/{registro}")
    public String delByEmpleadoRegistro(@PathVariable("id") int id, @PathVariable("registro") int registro){
        empleadoHorasInteractor.delByEmpleadoRegistro(empleadoHorasInteractor.getByEmpleadoRegistro(id, registro));
        return "redirect:/horas/" + id;
    }
    @PostMapping("api/empleados/horas/crear/{id}")
    public String crearEmpleado(@ModelAttribute EmpleadoHoras horas, @PathVariable("id") int id, RedirectAttributes redirectAttributes){
        horas.setId_empleado(id);
        if(empleadoHorasInteractor.SetHoras(horas) == null){
            redirectAttributes.addFlashAttribute("error", "La hora de inicio no puede ser posterior a la de finalización.");
        };
        return "redirect:/horas/{id}";
    }
}
