package Modelo;

import android.database.Cursor;
import com.example.listviewalumnos.Alumno;

import java.util.ArrayList;

public interface Proyeccion {
    Alumno getAlumno(String matricula);
    ArrayList<Alumno> allAlumnos();
    Alumno readAlumno(Cursor cursor);
}
