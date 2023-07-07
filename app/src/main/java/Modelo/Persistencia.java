package Modelo;

import com.example.listviewalumnos.Alumno;

public interface Persistencia {
    void openDataBase();
    void closeDataBase();
    long insertAlumno(Alumno alumno);
    long updateAlumno(Alumno alumno);
    long deleteAlumno(int id);
}
