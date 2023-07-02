package com.example.listviewalumnos;

public class AlumnoItem {

    private int id;
    private int imagen;

    private String nombre;
    private String matricula;

    public AlumnoItem() {
        this.imagen = imagen;
        this.nombre = nombre;
        this.matricula = matricula;
    }


    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }

    public int getImagenID() { // cambiamos el nombre de getImagen() a getImagenID()
        return imagen;
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
