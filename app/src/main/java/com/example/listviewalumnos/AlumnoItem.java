package com.example.listviewalumnos;

public class AlumnoItem {
    private int imagen;
    private String nombre;
    private String matricula;

    public AlumnoItem(int imagen, String nombre, String matricula) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
