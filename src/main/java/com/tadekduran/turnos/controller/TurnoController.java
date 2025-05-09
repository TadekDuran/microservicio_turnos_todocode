package com.tadekduran.turnos.controller;

import com.tadekduran.turnos.dto.TurnoDTO;
import com.tadekduran.turnos.model.Turno;
import com.tadekduran.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO turno)    {
        turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDniPaciente());
        return "Turno creado correctamente.";
    }

    @GetMapping("/traer")
    public List<Turno> traerTurnos()    {
        return turnoServ.getTurnos();
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id)    {
        turnoServ.deleteTurno(id);
        return "Turno Eliminado correctamente.";
    }

    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original, @RequestBody Turno turnoEditar){
        turnoServ.editTurno(id_original, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(id_original);
        return turnoEditado;
    }

    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id)  {
        return turnoServ.findTurno(id);
    }

}
