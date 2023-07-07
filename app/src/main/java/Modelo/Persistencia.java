package Modelo;

import com.example.listviewalumnos.Alumno;

public interface Persistencia {


    public void openDataBase();
    public void closeDataBase();
    public long updateALumno (Alumno alumno);

    long insertAlumno(Alumno alumno);

    public void deleteAlumnos (int id);

}
