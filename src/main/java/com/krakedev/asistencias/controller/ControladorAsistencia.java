package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.services.ServicioAsistencia;

@RestController
@RequestMapping("/asistencias")
public class ControladorAsistencia {

    private final ServicioAsistencia servicioAsistencia;

    // Inyección de dependencias por constructor
    public ControladorAsistencia(ServicioAsistencia servicioAsistencia) {
        this.servicioAsistencia = servicioAsistencia;
    }

    // POST /asistencias/{cedula} → registrar asistencia de un estudiante
    @PostMapping("/{cedula}")
    public RegistroAsistencia registrar(@PathVariable String cedula) {
        return servicioAsistencia.registrarAsistencia(cedula);
    }

    // GET /asistencias/{cedula} → consultar asistencias de un estudiante
    @GetMapping("/{cedula}")
    public ArrayList<Asistencia> consultar(@PathVariable String cedula) {
        return servicioAsistencia.consultarAsistencia(cedula);
    }
}