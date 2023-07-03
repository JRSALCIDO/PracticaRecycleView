package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class AlumnosDb implements Persistencia, Proyeccion{

    private Context context;
    private AlumnoDbHelper helper;
    private SQLiteDatabase db;

    public AlumnosDb(Context context, AlumnoDbHelper helper){
        this.context = context;
        this.helper = helper;
    }

    public AlumnosDb(Context context){
        this.context = context;
        this.helper = new AlumnoDbHelper(this.context);
    }


    @Override
    public void openDataBase() {
        db = helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
        helper.close();
    }

    @Override
    public long insertAlumno(AlumnoItem alumno) {

        ContentValues values = new ContentValues();

        values.put(DefineTabla.Alumnos.COLUMN_NAME_MATRICULA, alumno.getMatricula());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_FOTO, alumno.getImagenID());

        this.openDataBase();
        long num = db.insert(DefineTabla.Alumnos.TABLE_NAME, null, values);
        this.closeDataBase();
        Log.d("agregar", "insertAlumno: " + null);


        return num;
    }

    @Override
    public long updateAlumno(AlumnoItem alumno) {
        ContentValues values = new ContentValues();

        values.put(DefineTabla.Alumnos.COLUMN_NAME_MATRICULA, alumno.getMatricula());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_FOTO, alumno.getImagenID());

        this.openDataBase();
        long num = db.update(
                DefineTabla.Alumnos.TABLE_NAME,
                values,
                DefineTabla.Alumnos.COLUMN_NAME_ID + alumno.getId(),
                null);
        this.closeDataBase();

        return num;

    }

    @Override
    public long deleteAlumno(int id) {
        this.openDataBase();
        db.delete(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.COLUMN_NAME_ID + "=?",
                new String[] {String.valueOf(id)} );
        this.closeDataBase();
        return 0;
    }




    @Override
    public AlumnoItem getAlumno(String matricula) {

        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.REGISTRO,
                DefineTabla.Alumnos.COLUMN_NAME_ID + " = ?",
                new String[] {matricula},
                null, null, null);
        cursor.moveToFirst();
        AlumnoItem alumnoItem = readAlumno(cursor);

        return alumnoItem;
    }

    @Override
    public ArrayList<AlumnoItem> allAlumnos() {

        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.REGISTRO,
                null, null, null, null, null);
        ArrayList<AlumnoItem> alumnoItems = new ArrayList<AlumnoItem>();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AlumnoItem alumnoItem = readAlumno(cursor);
            alumnoItems.add(alumnoItem);
            cursor.moveToNext();
        }

        cursor.close();

        return alumnoItems;

    }

    @Override
    public AlumnoItem readAlumno(Cursor cursor) {
        AlumnoItem alumnoItem = new AlumnoItem();

        alumnoItem.setId(cursor.getInt(0));
        alumnoItem.setMatricula(cursor.getString(1));
        alumnoItem.setNombre(cursor.getString(2));
        return alumnoItem;
    }
}
