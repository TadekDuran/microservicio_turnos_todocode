package com.tadekduran.turnos.service;

import com.tadekduran.turnos.model.Turno;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ITurnoService {

    public List<Turno> getTurnos();

    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    public void deleteTurno(Long id);

    public Turno findTurno(Long id);

    public void editTurno(Long id, Turno turno);

}
