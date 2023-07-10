package com.example.listviewalumnos;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

import Modelo.AlumnosDb;

public class Aplicacion extends Application {

    public static ArrayList<Alumno> alumnos;
    private MiAdaptador adaptador;

    private AlumnosDb alumnosDb;



    public  ArrayList<Alumno> getAlumnos() {

        return alumnos;
    }

    public MiAdaptador getAdaptor() {

        return adaptador;
    }


    @Override
    public void onCreate() {
        super.onCreate();




        alumnosDb= new AlumnosDb(getApplicationContext());
       // alumnos =Alumno.llenarAlumnos();
        alumnos = alumnosDb.allAlumnos();
        alumnosDb.openDataBase();

        adaptador=new MiAdaptador(alumnos,this);
        Log.d("", "onCreate: tamaño array list" + alumnos.size());
    }
}


