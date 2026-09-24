package com.krakedev.asistencias.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
	
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    // CREATE
    public void agregar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // READ
    public Estudiante buscarPorCedula(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    //DELETE
    public void eliminar(String cedula) {
        Estudiante estudiante = buscarPorCedula(cedula);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
        }
    }

    // UPDATE
    public void actualizar(String cedula, Estudiante nuevo) {
        Estudiante estudiante = buscarPorCedula(cedula);
        if (estudiante != null) {
            estudiante.setNombre(nuevo.getNombre());
            estudiante.setApellido(nuevo.getApellido());
        }
    }

    // Retorna todos los estudiantes
    public ArrayList<Estudiante> listar() {
        return estudiantes;
    }

}
