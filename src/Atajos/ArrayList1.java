package Atajos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArrayList1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Crear lista de cursos
        System.out.println("Ingrese la cantidad de cursos:");
        int cantidadCursos = leer.nextInt();
        List<Curso> cursos = new ArrayList<>();

        for (int i = 0; i < cantidadCursos; i++) {
            System.out.println("Ingrese nombre del curso " + (i + 1) + " :");
            String nombreCurso = leer.next();
            System.out.println("Ingrese cantidad de créditos del curso:");
            int creditos = leer.nextInt();
            cursos.add(new Curso(nombreCurso, creditos));
        }

        // Crear lista de alumnos
        List<Alumno> alumnos = new ArrayList<>();
        String continuar;

        do {
            System.out.println("Ingrese nombre del alumno:");
            String nombreAlumno = leer.next();
            System.out.println("Ingrese código universitario del alumno:");
            String codigoUniversitario = leer.next();
            Alumno alumno = new Alumno(nombreAlumno, codigoUniversitario);

            for (Curso curso : cursos) {
                System.out.println("Ingrese la nota del curso " + curso.getNombre() + " para el alumno " + nombreAlumno + ":");
                int nota = leer.nextInt();
                alumno.agregarNota(curso, nota);
            }

            alumnos.add(alumno);
            System.out.println("Ponderado del alumno " + nombreAlumno + ": " + alumno.calcularPonderado());
            System.out.println("¿Desea agregar otro alumno? (si/no):");
            continuar = leer.next();
        } while (continuar.equalsIgnoreCase("si"));
    }
}

