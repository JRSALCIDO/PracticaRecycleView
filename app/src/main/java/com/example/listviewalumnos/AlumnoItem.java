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

    public int getImagenID() { // cambiamos el nombre de getImagen() a getImagenID()
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

}
