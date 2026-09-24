package com.krakedev.asistencias.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
	
	private final ServicioEstudiantes servicioEstudiantes;
	
	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
        this.servicioEstudiantes = servicioEstudiantes;
    }
	
	public RegistroAsistencia registrarAsistencia(String cedula) {

        // 1. Buscar el estudiante por cédula
        Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);

        // 2. Si no existe, retornar null
        if (estudiante == null) {
            return null;
        }

        // 3. Crear la asistencia con fecha y hora actuales
        Asistencia asistencia = new Asistencia();
        asistencia.setFechaClase(LocalDate.now());
        asistencia.setFechaHoraRegistro(LocalDateTime.now());
        asistencia.setEstado("P"); // P = Presente

        // 4. Crear el registro y asociar estudiante y asistencia
        RegistroAsistencia registro = new RegistroAsistencia();
        registro.setEstudiante(estudiante);
        registro.setAsistencia(asistencia);

        // 5. Agregar a la lista y retornar
        registros.add(registro);
        return registro;
    }

    // Consulta todas las asistencias de un estudiante por cédula
    public ArrayList<Asistencia> consultarAsistencia(String cedula) {

        ArrayList<Asistencia> asistencias = new ArrayList<>();

        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getCedula().equals(cedula)) {
                asistencias.add(r.getAsistencia());
            }
        }

        return asistencias;
    }

}
