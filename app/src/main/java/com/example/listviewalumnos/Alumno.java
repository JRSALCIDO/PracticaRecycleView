package com.example.listviewalumnos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Alumno  implements Serializable {

    private int id;
    private String carrera;
    private String nombre;
    private Integer img;
    private String matricula;


    public Alumno(){

    }

    public Alumno(String carrera, String nombre, Integer img, String matricula){
        this.carrera = carrera;
        this.nombre = nombre;
        this.img = img;
        this.matricula = matricula;
    }

    public String getGrado(){ return carrera; }
    public String getNombre(){ return nombre; }
    public int getImg(){ return img; }
    public String getMatricula(){ return matricula; }

    public void setGrado(String grado){this.carrera = grado; }
    public void setNombre(String nombre){this.nombre = nombre; }
    public void setImg(Integer img){this.img = img; }
    public void setMatricula(String matricula){this.matricula = matricula; }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static ArrayList<Alumno> llenarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String carrera = "Ing. Tec. Infromación";

        alumnos.add(new Alumno(carrera, "ARIAS ZATARAIN DIEGO", R.drawable.a2020030306, "2020030306"));
        alumnos.add(new Alumno(carrera, "VALDEZ MARTINEZ PAOLA EMIRET", R.drawable.a2020030313, "2020030313"));
        alumnos.add(new Alumno(carrera, "IBARRA FLORES SALMA YARETH", R.drawable.a2020030315, "2020030315"));
        alumnos.add(new Alumno(carrera, "LIZARRAGA MALDONADO JUAN ANTONIO", R.drawable.a2020030322, "2020030322"));
        alumnos.add(new Alumno(carrera, "VIERA ROMERO ANGEL ZINEDINE ANASTACIO", R.drawable.a2020030325, "2020030325"));
        alumnos.add(new Alumno(carrera, "TEJEDA PEINADO BLAS ALBERTO", R.drawable.a2020030327, "2020030327"));
        alumnos.add(new Alumno(carrera, "VIERA ROMERO ANGEL RONALDO ANASTACIO", R.drawable.a2020030329, "2020030329"));
        alumnos.add(new Alumno(carrera, "ELIZALDE VARGAS XIOMARA YAMILETH", R.drawable.a2020030332, "2020030332"));
        alumnos.add(new Alumno(carrera, "SALCIDO SARABIA JESUS ANTONIO", R.drawable.a2020030333, "2020030333"));
        alumnos.add(new Alumno(carrera, "RODRIGUEZ SANCHEZ YENNIFER CAROLINA", R.drawable.a2020030389, "2020030389"));
        alumnos.add(new Alumno(carrera, "FLORES PRADO MANUEL ALEXIS", R.drawable.a2020030766, "2020030766"));
        alumnos.add(new Alumno(carrera, "AGUIRRE TOSTADO VICTOR MOISES", R.drawable.a2020030771, "2020030771"));
        alumnos.add(new Alumno(carrera, "DOMINGUEZ SARABIA HALACH UINIC", R.drawable.a2020030777, "2020030777"));
        alumnos.add(new Alumno(carrera, "MACIEL NUÑEZ ENZO ALEJANDRO", R.drawable.a2020030799, "2020030799"));
        alumnos.add(new Alumno(carrera, "BARRON VARGAS JOSE ALBERTO", R.drawable.a2020030808, "2020030808"));
        alumnos.add(new Alumno(carrera, "MARTIN IBARRA GIANCARLO", R.drawable.a2020030819, "2020030819"));
        alumnos.add(new Alumno(carrera, "SANCHEZ OCEGUEDA LUIS ANGEL", R.drawable.a2020030865, "2020030865"));
        alumnos.add(new Alumno(carrera, "MORUA ZAMUDIO ESTEFANO", R.drawable.a2019030344, "2019030344"));
        alumnos.add(new Alumno(carrera, "CARRANZA JAUREGUI CARLOS ALBERTO", R.drawable.a2020030174, "2020030174"));
        alumnos.add(new Alumno(carrera, "CASTRO LOPEZ MARCO ANTONIO ALARID", R.drawable.a2020030176, "2020030176"));
        alumnos.add(new Alumno(carrera, "DURAN VALDEZ JOSHUA DANIEL", R.drawable.a2020030181, "2020030181"));
        alumnos.add(new Alumno(carrera, "GALINDO HERNANDEZ ERNESTO DAVID", R.drawable.a2020030184, "2020030184"));
        alumnos.add(new Alumno(carrera, "CONTRERAS CEPEDA MAXIMILIANO", R.drawable.a2020030189, "2020030189"));
        alumnos.add(new Alumno(carrera, "GOMEZ RUELAS IVÁN ENRIQUE", R.drawable.a2020030199, "2020030199"));
        alumnos.add(new Alumno(carrera, "CRUZ QUINTERO JESUS EDUARDO", R.drawable.a2020030212, "2020030212"));
        alumnos.add(new Alumno(carrera, "VELARDE OVALLE DAVID ANTONIO", R.drawable.a2020030241, "2020030241"));
        alumnos.add(new Alumno(carrera, "LAMAS ARMENTA GUSTAVO ADOLFO", R.drawable.a2020030243, "2020030243"));
        alumnos.add(new Alumno(carrera, "RIVAS LUGO JUAN CARLOS", R.drawable.a2020030249, "2020030249"));
        alumnos.add(new Alumno(carrera, "SALAS MENDOZA ALEJO", R.drawable.a2020030264, "2020030264"));
        alumnos.add(new Alumno(carrera, "SERRANO TORRES CARLOS JAIR", R.drawable.a2020030268, "2020030268"));
        alumnos.add(new Alumno(carrera, "TIRADO ROMERO JESUS TADEO", R.drawable.a2020030292, "2020030292"));
        alumnos.add(new Alumno(carrera, "CARRILLO GARCIA JAIR", R.drawable.a2020030304, "2020030304"));



        return alumnos;

    }


}
