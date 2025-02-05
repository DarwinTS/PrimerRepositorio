package Atajos;

import java.util.HashMap;
import java.util.Map;

public class Alumno {
    private String nombre;
    private String codigoUniversitario;
    private Map<Curso, Integer> notas; // Mapa de Curso y sus respectivas notas

    public Alumno(String nombre, String codigoUniversitario) {
        this.nombre = nombre;
        this.codigoUniversitario = codigoUniversitario;
        this.notas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoUniversitario() {
        return codigoUniversitario;
    }

    public void agregarNota(Curso curso, int nota) {
        notas.put(curso, nota);
    }

    public double calcularPonderado() {
        int totalCreditos = 0;
        int sumaPonderada = 0;

        for (Map.Entry<Curso, Integer> entrada : notas.entrySet()) {
            totalCreditos += entrada.getKey().getCreditos();
            sumaPonderada += entrada.getValue() * entrada.getKey().getCreditos();
        }

        return totalCreditos > 0 ? (double) sumaPonderada / totalCreditos : 0;
    }
}

